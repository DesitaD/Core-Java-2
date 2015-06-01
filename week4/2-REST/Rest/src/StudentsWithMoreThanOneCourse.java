import java.io.IOException;
import java.util.HashSet;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;




public class StudentsWithMoreThanOneCourse {
    
    public static JSONArray getAllStudents(String url) throws IOException, JSONException{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
     
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity1 = response.getEntity();
            String students = EntityUtils.toString(entity1);
            JSONArray allStudents= new JSONArray(students);
            return allStudents; 
            
        } finally {
            response.close();
        }
        
    }
    
    public static HashSet<String> getStudentsWithMoreCourses(JSONArray allStudents) throws JSONException{
        HashSet<String> hs=new HashSet<String>();
        for(int i=0; i<allStudents.length();i++){
            JSONObject student = (JSONObject) allStudents.get(i);
            JSONArray courses = (JSONArray) student.get("courses");
            if(courses.length()>1){
                hs.add((String) student.get("name"));
            }
        }
        return hs;
    }
    
    public static void printStudentsWithMoreThanOneCourses() throws IOException, JSONException{
        
        String url = "https://hackbulgaria.com/api/students/";
        JSONArray allStudents= getAllStudents(url);
        HashSet<String> studentsWithMoreCourses = getStudentsWithMoreCourses(allStudents);
        for (String student : studentsWithMoreCourses) {
            System.out.println(student);            
        }
        
        
    }

    public static void main(String[] args) throws IOException, JSONException {
        printStudentsWithMoreThanOneCourses();

    }

}
