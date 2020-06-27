package repeatableannotationsandtypeannotations;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class TestRepeatableAnnotations {

    @MyAnnotation("huya")
    @MyAnnotation("douyu")
    public void test(@MyAnnotation("lanjing") String type){

    }

    @Test
    public void getAnnotations() throws NoSuchMethodException {
        Class<TestRepeatableAnnotations> testRepeatableAnnotationsClass = TestRepeatableAnnotations.class;
        Method test = testRepeatableAnnotationsClass.getDeclaredMethod("test",String.class);
        test.setAccessible(true);
        AnnotatedType annotatedReceiverType = test.getAnnotatedReceiverType();
        System.out.println(annotatedReceiverType.getType());

        MyAnnotation[] annotationsByType = test.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println(myAnnotation.value());
        }


        Annotation[][] parameterAnnotations = test.getParameterAnnotations();//获取参数注解
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                System.out.println(((MyAnnotation)annotation).value());
            }
        }
    }
}
