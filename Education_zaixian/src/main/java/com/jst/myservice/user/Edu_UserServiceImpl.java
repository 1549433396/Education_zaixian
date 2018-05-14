package com.jst.myservice.user;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.user.EduUserMapper;
import com.jst.model.Edu_User;

@Service
public class Edu_UserServiceImpl implements Edu_UserService{
    
	@Autowired
	private EduUserMapper eduUserMapper;

	@Override
	public List<Edu_User> listAll(Map map) {
		List<Edu_User> list=eduUserMapper.listAll(map);
		return list;
	}

	@Override
	public void save(Edu_User eduUser) {
		eduUserMapper.save(eduUser);
		
	}
	
	
	
	 /*public String parseExcel(InputStream in)throws Exception{
	       //获取Excel文件对象  
	       Workbook  rwb = Workbook.getWorkbook(in);  
	       //获取文件的指定工作表 默认的第一个  
	       Sheet sheet = rwb.getSheet(0);    
	       //行数(表头的目录不需要，从1开始)  
	       List<User> list=new ArrayList<User>();
	       for(int i=2; i<sheet.getRows(); i++){  
	            //创建一个数组 用来存储每一列的值  
	           String[] str = new String[sheet.getColumns()];  
	           Cell cell = null;  
	           //列数  
	           User user=new User();
	           for(int j=0; j<sheet.getColumns(); j++){  
	             //获取第i行，第j列的值  
	             cell = sheet.getCell(j,i);      
	             str[j] = cell.getContents();  
	             System.out.print(str[j]+" ");
	             if(j==0){
	           	  user.set(str[j]);
	             }
	             if(j==1){
	           	  user.setPassword(str[j]);
	             }
	             if(j==2){
	           	  user.setSex(str[j]);
	             }
	           }  
	           list.add(user);
	           System.out.println("");
	       }  
		   return "sucess";
	   }*/

	@Override
	public void delete(int user_id) {
		eduUserMapper.delete(user_id);
		
	}

	@Override
	public Edu_User getById(int user_id) {
		Edu_User eduUser=eduUserMapper.getById(user_id);
		return eduUser;
	}

	@Override
	public void update(Map map) {
		eduUserMapper.update(map);
		
	}

	@Override
	public void updateFozen(Map map) {
		eduUserMapper.updateFozen(map);
		
	}
	
	
	/**
	 * 解析Excel
	 * @param in
	 * @return
	 * @throws Exception
	 */
	/*public int parseExcel(InputStream in)throws Exception{ 
		    List<EduUser> list=new ArrayList<>();
		   EduUser eduUser=null;
		    int count=0;
		    try {
				HSSFWorkbook hssfWorkbook=new HSSFWorkbook(in);
				for (int num = 0; num < hssfWorkbook.getNumberOfSheets(); num++) {
					HSSFSheet hssfSheet=hssfWorkbook.getSheetAt(num);
					if (hssfSheet==null) {
						continue;
					}
					for (int rownum = 2; rownum <= hssfSheet.getLastRowNum(); rownum++) {
						HSSFRow hssfRow=hssfSheet.getRow(rownum);
						System.out.println("开始======"+hssfRow.getLastCellNum());
					    eduUser=new EduUser();
					    for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
							HSSFCell cell=hssfRow.getCell((short) i);
							if (i!=8) {
								hssfRow.getCell((short) i).setCellType(cell.CELL_TYPE_STRING);
							}
							if (i==0) {
								eduUser.setUser_name(hssfRow.getCell((short) 2).getStringCellValue());
							}
							if (i==1) {
								eduUser.setMobile(hssfRow.getCell((short) 3).getStringCellValue());
							}
							if (i==2) {
								eduUser.setEmail(hssfRow.getCell((short) 4).getStringCellValue());
							}
							if (i==3) {
								eduUser.setPassword(hssfRow.getCell((short) 5).getStringCellValue());
							}
							if (i==4) {
								eduUser.setUser_name(hssfRow.getCell((short) 6).getStringCellValue());
							}
							if (i==5) {
								eduUser.setShow_name(hssfRow.getCell((short) 7).getStringCellValue());
							}
							if (i==6) {
								eduUser.setSex(hssfRow.getCell((short) 7).getCellNum());
							}
							if (i==7) {
								eduUser.setAge(hssfRow.getCell((short) 7).getCellNum());
							}
							if (i==8) {
								eduUser.setCreate_time(hssfRow.getCell((short) 7).getDateCellValue());
							}
							list.add(eduUser) ;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		return count;
	}*/
	
}
