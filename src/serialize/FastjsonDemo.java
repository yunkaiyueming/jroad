package serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }
}

public class FastjsonDemo {

    public static void main(String[] args) {
        //对象转json字符串
        User u1 = new User("aa", "xjiewqr");
        String u1Str = JSON.toJSONString(u1);
        System.out.println(u1Str);

        User u2 = new User("bb", "fasfda");
        List<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
        String u2Str = JSON.toJSONString(users);
        System.out.println(u2Str);

        //json字符串转到bean上
        User utmp = JSON.parseObject(u1Str, User.class);
        System.out.println(utmp);

        //json字符串转list
        List<User> utmp2 = JSON.parseArray(u2Str, User.class);
        System.out.println(utmp2);
//        for(User v:utmp2){
//            System.out.println(v.getUsername()+v.getPassword());
//        }

        Map<String, User> u = new HashMap<String, User>();
        u.put("c1", u1);
        u.put("c2", u2);
        String ustr = JSON.toJSONString(u);
        System.out.println(ustr);

        //Map.Entry<Integer, Integer> entry : map.entrySet()
        JSONObject objs = JSON.parseObject(ustr);
        System.out.println(JSON.parseObject(objs.getString("c1")).getString("username"));

        //解析到map上
        Map<String, User> objs2 = JSON.parseObject(ustr, Map.class);
        for (Map.Entry<String, User> entry : objs2.entrySet()) {
            //User v = entry.getValue();
            System.out.println(entry.getKey() + entry.getValue());

            User uaa = JSON.parseObject(String.valueOf(entry.getValue()), User.class);
            System.out.println(uaa.getUsername() + uaa.getPassword());
        }
    }

    public static Object map2Object(Map<String, Object> map, Class<?> clazz) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = clazz.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                String flag = (String) map.get(field.getName());
                if (flag != null) {
                    if (flag.equals("false") || flag.equals("true")) {
                        field.set(obj, Boolean.parseBoolean(flag));
                    } else {
                        field.set(obj, map.get(field.getName()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
