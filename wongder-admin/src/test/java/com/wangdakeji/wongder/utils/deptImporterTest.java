package com.wangdakeji.wongder.utils;
import com.wangdakeji.wongder.base.BaseJunit;
import com.wangdakeji.wongder.common.persistence.dao.DeptMapper;
import com.wangdakeji.wongder.common.persistence.model.Dept;
import com.wangdakeji.wongder.modular.system.dao.DeptDao;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * test for dept importer
 * Created by wangda
 * on 17-10-31
 */
public class deptImporterTest extends BaseJunit {
    @Resource
    private DeptMapper deptMapper;

    @Resource
    private DeptDao deptDao;

    private String NULL= "";
    private char COMMA = ',';
    private String EMPTY="--";

    @Test
    public void testReadXls() {
//        DeptImporter importer = new DeptImporter();
        try {
            readXls("/mnt/hgfs/U/WDJL.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void readXls(String filePath) throws Exception {

        InputStream is = new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

        for(int sheetNum = 0; sheetNum<xssfWorkbook.getNumberOfSheets();sheetNum++){
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetNum);
            if(xssfSheet == null){
                continue;
            }
            //duan
            List<Map<String,Object>> duanDeptList = deptDao.list(xssfSheet.getSheetName());
            Dept duanDept=null;
            if(duanDeptList.isEmpty()){
                //creat duan
                Dept duanDeptTmp = new Dept();
                duanDeptTmp.setPid(0);
                duanDeptTmp.setPids("[0],");
                duanDeptTmp.setSimplename(xssfSheet.getSheetName());
                duanDeptTmp.setFullname(xssfSheet.getSheetName());
                deptMapper.insert(duanDeptTmp);
                duanDept=duanDeptTmp;
            }

            //从第4行开始读取
            for(int rowNum = 3;rowNum<xssfSheet.getLastRowNum();rowNum++){
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                String chejianFullField = xssfRow.getCell(0).toString().trim().replaceAll("\\s*|t|r|n",NULL);
                String chejianSimpleField= getSimpleField(chejianFullField);
                List<Map<String,Object>> chejianDeptList = deptDao.getBySimpleName(chejianSimpleField);
                if(chejianFullField!=null&&!chejianDeptList.isEmpty()) {
                    //chejian
                    Dept chejianDept=null;
                    if (chejianDeptList.isEmpty()) {
                        //create dept:chejian, normally simplename is unique so we can get the first record
                        Dept chejianDeptTmp = new Dept();
                        if(chejianSimpleField!=null)
                            chejianDeptTmp.setSimplename(chejianSimpleField);
                        else
                            chejianDeptTmp.setSimplename(EMPTY);
                        chejianDeptTmp.setFullname(chejianFullField);
                        if(duanDept==null)
                            setPdeptinfo(chejianDeptTmp,duanDeptList.get(0));
                        else
                            setPdeptinfo(chejianDeptTmp,duanDept);
                        deptMapper.insert(chejianDeptTmp);
                        chejianDept=chejianDeptTmp;
                    }
                    //gongqu
                    String gongquFullField = xssfRow.getCell(1).toString().trim().replaceAll("\\s*|t|r|n",NULL);
                    String gongquSimpleField= getSimpleField(gongquFullField);
                    List<Map<String,Object>> gongquDeptList = deptDao.getBySimpleName(gongquSimpleField);
                    if(gongquFullField!=null&&!gongquDeptList.isEmpty()) {
                        Dept gongquDept=null;
                        if (gongquSimpleField==null||gongquDeptList.size()==0) {
                            //create dept:gongqu
                            Dept gongquDeptTmp = new Dept();
                            gongquDeptTmp.setSimplename(gongquSimpleField);
                            gongquDeptTmp.setFullname(gongquFullField);
                            if(chejianDept==null)
                                setPdeptinfo(gongquDeptTmp,chejianDeptList.get(0));
                            else
                                setPdeptinfo(gongquDeptTmp,chejianDept);
                            deptMapper.insert(gongquDeptTmp);
                            gongquDept=gongquDeptTmp;
                        }

                        String stationSimpleName = xssfRow.getCell(3).toString().trim();
                        String stationFullname = xssfRow.getCell(2).toString().trim();
                        List<Map<String,Object>> stationDeptList = deptDao.getBySimpleName(stationSimpleName);
//                        List<Map<String,Object>> stationDeptList = deptDao.list(stationSimpleName);
//                        List<Map<String,Object>> stationDeptList2 = deptDao.list(stationFullname);
                        //create or update station
                        if(!stationSimpleName.isEmpty()&&!stationFullname.isEmpty()&&
                                stationDeptList.isEmpty()) {
                            Dept stationDept = new Dept();
                            stationDept.setFullname(stationFullname);
                            stationDept.setSimplename(stationSimpleName);
                            if(gongquDept==null)
                                setPdeptinfo(stationDept, gongquDeptList.get(0));
                            else
                                setPdeptinfo(stationDept, gongquDept);
                            deptMapper.insert(stationDept);
                        }
//                      else {
//                              stationDept.setId((Integer)gongquDeptList.get(0).get("id"));
//                              deptMapper.updateAllColumnById(stationDept);
//                           }
                    }

                }
            }
        }

    }

    private String getSimpleField(String field) {
        StringBuilder result = new StringBuilder();
        if(field!=null&&!field.isEmpty()){

            for(int i=0;i< field.length();i++){
                char aChar=field.charAt(i);
                if((aChar<='z'&&aChar>='a')||(aChar<='Z'&&aChar>='A')){
                    result.append(aChar);
                    if(i!=field.length()-1) {
                        char nextChar=field.charAt(i + 1);
                        if ((nextChar<'A'||('Z'<nextChar&&nextChar<'a')||nextChar>'z')||(nextChar==COMMA)){
                            result.append(COMMA);
                        }
                    }
                }
            }
        }

        return result.toString();
    }
    private void setPdeptinfo(Dept dept,Map<String,Object> pdept){
        dept.setPid((Integer)pdept.get("id"));
        dept.setPids(pdept.get("pids") + "[" + pdept.get("id") + "],");

    }
    private void setPdeptinfo(Dept dept,Dept pdept){
        dept.setPid(pdept.getId());
        dept.setPids(pdept.getPids() + "[" + pdept.getId() + "],");

    }
}
