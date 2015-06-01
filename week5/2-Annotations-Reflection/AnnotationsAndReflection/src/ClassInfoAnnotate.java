import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
    @interface classInfo{
        String classAuthor();
        int revisionOfClass() default 1;
        boolean checked() default true;
        Class <?> [] related();
    }
    
    @classInfo(
            classAuthor= "Peter Peterson",
            related={String.class, Integer.class})    
public class ClassInfoAnnotate {

    public static void main(String[] args) {
        Class annotatedClass= ClassInfoAnnotate.class;
        Annotation[] someAnnotation= annotatedClass.getAnnotations();
        for( Annotation annotation : someAnnotation ){            
            if(annotation instanceof classInfo){
                classInfo myAnnotation = (classInfo) annotation;
                System.out.println("author: " + ((classInfo) myAnnotation).classAuthor());
                System.out.println("revision: " +((classInfo) myAnnotation).revisionOfClass());
            }
          }
        someAnnotation.getClass().getAnnotation(classInfo.class);
       

    }

}
