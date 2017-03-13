import java.util.Scanner;

public class Szys2 {
    public static void main(String[] args) {
        System.out.println("请输入要生成的题数：");
        Scanner N = new Scanner(System.in);
        int n=N.nextInt();
        System.out.println("请输入出题的类型：（1.整数   2.真分数）");
        Scanner N1 = new Scanner(System.in);
        int n1=N1.nextInt();
        //("注：除法请填写化简之后的结果（分母为1时也要写出）");
        
        System.out.println("请输入数字的取值范围（起始和结束的正整数）：");
        Scanner N5 = new Scanner(System.in);
        int n5=N5.nextInt();
        Scanner N6 = new Scanner(System.in);
        int n6=N6.nextInt();
        
        if(n1==1)  zheng(n5,n6,n);
        else if(n1==2)  zhenfs(n5,n6,n);
        else System.out.println("输入错误！");
    }
    
    public static int random(int w,int v)
    {
        int value=w + (int) ( Math.random() * v );
        return value;
    }
    public static void jisuan1(int n,int value1,int value2,int ys,int i)
    {
        String ys1;
        String result[] =new String[n];
        String output[] =new String[n];
        
        if(ys==1) {ys1="+";result[i]=value1+value2+"";}
        else if(ys==2) {ys1="-";result[i]=(value1-value2)+"";}
        else if(ys==3) {ys1="*";result[i]=(value1*value2)+"";}
        else {ys1="/";result[i]=yuefen(value1,value2);}
        output[i]= value1 + " "+ys1 +" "+ value2+"=";
        System.out.println(output[i]);
        
        Scanner N2 = new Scanner(System.in);
        String n2=N2.nextLine();
        if(n2.equals(result[i]))
             System.out.println("回答正确！");
        else System.out.println("回答错误！");
    }
    
    public static void jisuan2(int n,int value1,int value2,int value3,int value4,int ys,int i)
    {
        String ys1;
        String result[] =new String[n];
        String output[] =new String[n];
        if(ys==1) {ys1="+";result[i]=yuefen(((value1*value4)+(value2*value3)),value2*value4)+"";}
        else if(ys==2) {ys1="-";result[i]=yuefen(((value1*value4)-(value2*value3)),value2*value4)+"";}
        else if(ys==3) {ys1="*";result[i]=yuefen((value1*value3),(value2*value4))+"";}
        else {ys1="/";result[i]=yuefen((value1*value4),(value2*value3))+"";}
        
        output[i]= yuefen(value1,value2)+" "+ys1+" "+yuefen(value3,value4)+"=";
        System.out.println(output[i]);
           
        Scanner N2 = new Scanner(System.in);
        String n2=N2.nextLine();
        if(n2.equals(result[i]))
             System.out.println("回答正确！");
        else 
        	System.out.println("回答错误！");
    }
   
     public static String yuefen(int a1,int a2)
     {
         int min=a1<a2?a1:a2;
         int yueshu=1;
         for(int i=min;i>=1;i--)
         {
             if(a1%i==0 && a2%i==0)
             {
                 yueshu=i;
                 break;
             }
         }
         a1/=yueshu;
         a2/=yueshu;
         return(a1+"/"+a2);
     }
    
    public static void zheng(int x,int y,int n)
    {
        int value1,value2;
        int ys;
        String ys1;
        
        System.out.println("请选择加减有无负数（1.有   2.无）：");
        Scanner N3 = new Scanner(System.in);
        int n3=N3.nextInt();
        
        System.out.println("请选择是否有乘除法（1.有   2.无）：");
        Scanner N4 = new Scanner(System.in);
        int n4=N4.nextInt();
        
        System.out.println("请选择除法有无余数（1.有   2.无）：");
        Scanner N7 = new Scanner(System.in);
        int n7=N7.nextInt();
           
        for ( int i = 0; i < n; i++ ) 
        {
           value1 = random(x,y);
           value2 = random(x,y);
           
           if(n3==1&&n4==1&&n7==1)  //加减有负数，有乘除法，有余数
           {
               ys = random(1,4);
               if(value1%value2!=0)
                  jisuan1(n,value1,value2,ys,i);
               else n++;
           }
           else if(n3==1&&n4==1&&n7==2)  //加减有负数，有乘除法，无余数
           {
               ys = random(1,4);
               if(value1>=value2&&value1%value2==0)
                  jisuan1(n,value1,value2,ys,i);
               else n++;
           }
           else if(n3==1&&n4==2)  //无乘除法
           {
               ys = random(1,2);
               jisuan1(n,value1,value2,ys,i);
           }
           else if(n3==2)  //加减无负数
           {
               if(value1>=value2&&n4==1&&n7==1)  //有乘除法，有余数
               {
                    ys = random(1,4);
                    if(value1%value2!=0)
                        jisuan1(n,value1,value2,ys,i);
                    else n++;
               }
               else if(value1>=value2&&n4==1&&n7==2)  //有乘除法，无余数
               {
                    ys = random(1,4);
                    if(value1%value2==0)
                        jisuan1(n,value1,value2,ys,i);
                    else n++;
               }
               else if(value1>=value2&&n4==2)  //无乘除法
               {
                     ys = random(1,2);
                     jisuan1(n,value1,value2,ys,i);
               }
               else if(value1<value2) n++;
           }
           else 
           {
               System.out.println("输入错误！");
               break;
           }
        }
          
    }
    public static void zhenfs(int x,int y,int n)
    {
        int value1,value2,value3,value4,ys;
        String ys1;
        
        System.out.println("请选择加减有无负数（1.有   2.无）：");
        Scanner N3 = new Scanner(System.in);
        int n3=N3.nextInt();
        
        System.out.println("请选择是否有乘除法（1.有   2.无）：");
        Scanner N4 = new Scanner(System.in);
        int n4=N4.nextInt();
        
        System.out.println("请选择除法有无余数（1.有   2.无）：");
        Scanner N7 = new Scanner(System.in);
        int n7=N7.nextInt();
           
        for ( int i = 0; i < n; i++ ) 
        {
           value1 = random(x,y);
           value2 = random(x,y);
           value3 = random(x,y);
           value4 = random(x,y);
           if(value1<value2&&value3<value4)
           {
               if(n3==1&&n4==1&&n7==1)  //加减有负数，有乘除法，有余数
               {
                   ys = random(1,4);
                   if(((double)value1/value2)>=((double)value3/value4)&&((double)value1/value2)%((double)value3/value4)!=0)
                       jisuan2(n,value1,value2,value3,value4,ys,i);
                   else n++;
               }
               else if(n3==1&&n4==1&&n7==2)  //加减有负数，有乘除法，无余数
               {
                   ys = random(1,4);
                   if(((double)value1/value2)>=((double)value3/value4)&&((double)value1/value2)%((double)value3/value4)==0)
                       jisuan2(n,value1,value2,value3,value4,ys,i);
                   else n++;
               }
               else if(n3==1&&n4==2)  //无乘除法
               {
                   ys = random(1,2);
                   jisuan2(n,value1,value2,value3,value4,ys,i);
               }
               else if(n3==2)  //加减无负数
               {
                   if(((double)value1/value2)>=((double)value3/value4)&&n4==1&&n7==1)//有乘除法，有余数
                   {
                        ys = random(1,4);
                        if(((double)value1/value2)%((double)value3/value4)!=0)
                            jisuan2(n,value1,value2,value3,value4,ys,i);
                        else n++;
                   }
                   else if(((double)value1/value2)>=((double)value3/value4)&&n4==1&&n7==2)//有乘除法，无余数
                   {
                        ys = random(1,4);
                        if(((double)value1/value2)%((double)value3/value4)==0)
                            jisuan2(n,value1,value2,value3,value4,ys,i);
                        else n++;
                   }
                   else if(((double)value1/value2)>=((double)value3/value4)&&n4==2)//无乘除法
                   {
                         ys = random(1,2);
                         jisuan2(n,value1,value2,value3,value4,ys,i);
                   }
                   else if(((double)value1/value2)<((double)value3/value4)) n++;
               }
               else 
               {
                   System.out.println("输入错误！");
                   break;
               }
            }
            else n++;
        }
    }
}