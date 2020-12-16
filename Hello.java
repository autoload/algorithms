public class Hello {
    public static void main(String[] args) {
        
        int[] array = new int[] {30,54,23,88,55};
        int len = array.length;
        int max = 0;
        int second = 0;
        for(int i=0; i<len; i++){
            if(max < array[i]){
                second = max;
                max = array[i];
            } else if (second < array[i]){
                second = array[i];
            }
        }
        System.out.println(max + "----" + second);

        

    }

/*

求和 最大值

continue 跳过本次循环
break 退出循环

循环
int sum = 0, i = 0;
        while (i < 10) {
            sum += 1;
            i++;
        }
        System.out.println(sum);

int sum = 0;
        for (int i = 0; i < 10; i++){
            sum += 1;
        }
        System.out.println(sum);

判断
if(){
    
} else if(){
    
}else{
    
}

数组
int[] socre = new int[] {90,20,100,32};

        int[] array = new int[2];
        array[0] = 22;
        array[1] = 32;

        System.out.println(array[0]);


布尔类型
boolean female = true;
double socre = 3.5;
boolean pass = (female && socre >= 3.0) || (!female && socre >= 4.0);
System.out.println(pass);

char 类型
字符对应着一个整数
        char a = 'a';
        int b = (int)a + 1;
        char c = (char)b;
        System.out.println(c);

        char char_a = 'a';
        char char_A = 'A';
        char char_0 = '0';
        int int_a = (int)char_a;
        int int_A = (int)char_A;
        int int_0 = (int)char_0;

        System.out.println(int_A);
        System.out.println(int_a);
        System.out.println(int_0);
        //大小写相差32
        

        System.out.println((char)(char_a + ('A' - 'a')));



*/

/*
替换空格
//String s = "We are happy.";
//String res = replaceSpace(s);
    public static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
*/

/*
//替换空格
    public static String replaceSpace(String s) {
        char arr[]=new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            arr[i]=s.charAt(i);
        }
        StringBuffer ss = new StringBuffer();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==' ')
            {
                ss.append("%20");
            }
            else
            {
                ss.append(arr[i]);
            }
        }
        String res = ss.toString();
        return res;
    }
*/

}
