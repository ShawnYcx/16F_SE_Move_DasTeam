// //CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
// package implementation;

// import MySQL.MySQLAccess;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// public class GetClass {
// 	MySQLAccess access;
// 	// This is a array of pre-requisite of courses
// 	// private List<String> listOfPreReq = new ArrayList<String>();
// 	// //Map<String, List<String>> listOfStudentInfo = new HashMap<String, List<String>>();
// 	// private List<String> listOfStudentInfo = new ArrayList<String>();

// 	private List<String> listOfClassInfo = new ArrayList<String>();

// 	// public void takeListOfStudents(String firstName, String lastName){
// 	// 	access = new MySQLAccess();

// 	// 	listOfStudentInfo = access.getStudentInfo(firstName, lastName);
// 	// }
 
// 	// public void getPreReqData(String subCode, String cNumber){
// 	// 	try {
// 	// 		access = new MySQLAccess();
// 	// 		listOfPreReq = access.getPreReqData1(subCode, cNumber);
// 	// 	} catch (Exception e) {
//  //                     //throw e;
// 	// 	} finally {
		     
// 	// 	}
// 	// }


// 	public void getClassData(String subCode, String cNumber){
// 		access = new MySQLAccess();

// 		listOfClassInfo = access.getClassInfo(subCode, cNumber);
// 	}

// 	// public boolean doCheckings(){

        
//  //        if ((listOfPreReq == null) || (listOfPreReq.isEmpty()) || (listOfPreReq.size() == 0) || (listOfPreReq.get(0).equals(""))){
//  //            return true;
//  //        }
			      

// 	// 	List<String> part = Arrays.asList(listOfPreReq.get(0).split(","));
// 	// 	List<String> info = new ArrayList<String>();
        
// 	// 	for (int i = 0; i < listOfStudentInfo.size(); i+=2) {
// 	// 		String a = listOfStudentInfo.get(i) + listOfStudentInfo.get(i+1);
// 	// 		info.add(a);   
// 	// 	}
		
// 	// 	for (int i = 0; i < part.size(); i++) {
// 	// 		if (!info.contains(part.get(i))){
// 	// 			return false;
// 	// 		}
// 	// 	}

// 	// 	return true;
// 	// }

// 	// public void printPreReqData(String subCode, String cNumber){
// 	// 	getPreReqData(subCode, cNumber);
// 	// 	System.out.println(listOfPreReq);
// 	// }
    
//    public boolean checkClassExist(){
// 		if ((listOfClassInfo == null) || (listOfClassInfo.isEmpty()) || (listOfClassInfo.size() == 0) || (listOfClassInfo.get(0).equals(""))){
// 		    return true;
// 		}

// 		return false;
//     }

//   //   public boolean checkStudentExist(){
// 		// if ((listOfStudentInfo == null) || (listOfStudentInfo.isEmpty()) || (listOfStudentInfo.size() == 0) || (listOfStudentInfo.get(0).equals(""))){
// 		//     return true;
// 		// }

// 		// return false;
//   //   }

//   //   public void printClassTaken(){
//   //   	List<String> info = new ArrayList<String>();
    	
//   //   	for (int i = 0; i < listOfStudentInfo.size(); i+=2) {
// 		// 	String a = listOfStudentInfo.get(i) + listOfStudentInfo.get(i+1);
// 		// 	info.add(a);   
// 		// }

//   //   	System.out.println(info);
//   //   }

//     public void printStudentInClass(){
    	
//     	for (int i = 0; i < listOfClassInfo.size(); i+=2) {
// 			 System.out.println(listOfClassInfo.get(i+1) + ", " + listOfClassInfo.get(i) + " Classification: " + listOfClassInfo.get(i+2));
// 		}
//     }
// }








