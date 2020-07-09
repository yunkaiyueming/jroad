package reflect;

import reflect2.Bean;
import reflect2.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

//使用反射获取泛型信息 获取类的属性，函数参数 函数返回值等信息
public class Demo3 {

    private Map<String, Object> objectMap;

    public void test(Map<String, User> map, String string) {
    }

    public Map<User, Bean> test() {
        return null;
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Demo3 de = new Demo3();
        de.testFieldType();
        System.out.println("=================");

        de.testParamType();
        System.out.println("=================");

        de.testReturnType();
        System.out.println("=================");
    }

    /**
     * 测试属性类型
     *
     * @throws NoSuchFieldException
     */
    public void testFieldType() throws NoSuchFieldException {
        Field field = Demo3.class.getDeclaredField("objectMap");//objectMap属性
        Type gType = field.getGenericType();
        // 打印type与generic type的区别
        System.out.println(field.getType());
        System.out.println(gType);
        System.out.println("**************");
        if (gType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) gType;
            Type[] types = pType.getActualTypeArguments();
            for (Type type : types) {
                System.out.println(type.toString());
            }
        }
    }

    /**
     * 测试参数类型
     *
     * @throws NoSuchMethodException
     */
    public void testParamType() throws NoSuchMethodException {
        Method testMethod = Demo3.class.getMethod("test", Map.class, String.class);
        Type[] parameterTypes = testMethod.getGenericParameterTypes();
        for (Type type : parameterTypes) {
            System.out.println("type -> " + type);
            if (type instanceof ParameterizedType) {
                Type[] actualTypes = ((ParameterizedType) type).getActualTypeArguments();
                for (Type actualType : actualTypes) {
                    System.out.println("/tactual type -> " + actualType);
                }
            }
        }
    }

    /**
     * 测试返回值类型
     *
     * @throws NoSuchMethodException
     */

    public void testReturnType() throws NoSuchMethodException {
        Method testMethod = Demo3.class.getMethod("test");
        Type returnType = testMethod.getGenericReturnType();
        System.out.println("return type -> " + returnType);

        if (returnType instanceof ParameterizedType) { ////ParameterizedType 一种参数化类型, 比如Collection<String>
            Type[] actualTypes = ((ParameterizedType) returnType).getActualTypeArguments();
            for (Type actualType : actualTypes) {
                System.out.println("/tactual type -> " + actualType);
            }
        }
    }
}