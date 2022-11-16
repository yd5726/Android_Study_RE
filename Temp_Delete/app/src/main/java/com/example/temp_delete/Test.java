package com.example.temp_delete;

//1
public class Test {
    // 인스턴스 멤버 3개 만들기
        // 클래스 중괄호 사이 ==> 전부 멤버임
        // 메모리에 올리는 순서
        // 앞에 static 이 붙었는지 여부 체크
    // 변수 2, 메소드 1
    int iV1, iV2;
    void iMethod(){
        sV1 = 1;
        sV2 = 2;

        int test = 0; // 지역변수는 그 안에서 생명주기가 끝난다.
    }//iMethod()

    // 스태틱 멤버 3개 만들기
    // 변수 2, 메소드 1
    static int sV1, sV2;
    static void sMethod(){
        //iV1 = 10; //오류
        Test test = new Test();
        test.iV1 = 10;
    }//sMethod()

    // MainActivity 에서 전부 다 호출 사용하기

    // 멤버 <- 내가 알고있는 모든 것들은 멤버로 사용 가능
    // . 메인액티비티에서 Sub 의 모든 멤버 접근해서 사용하기
    //2
    class Sub{
        String sub_v1;
        void subMethod() {

        }
    }//Sub

    static class sSub{
        static int subV2;
        static void subMethod2(){

        }
        String subV1;
        void subMethod(){
            //iV1 = 1; // 오류 : static 필드 안에 존재하지 않는다.
            Test test = new Test(); // static 은 먼저 메모리에 올라가기 때문에
                                    // 일반적으로는 접근이 x
                                    // static 이 메모리에 올라갈 때 인스턴스화해서 가지고 가야함.
            test.iV1 = 10;
        }
    }//sSub

//    public int getiV1(){
//        return iV1;
//    }
//    public void setiV1(int iV1){
//        this.iV1 = iV1;
//    }

    // lClass에 있는 모든 멤버를 사용하기
        // 메소드 내부에서 만든 모든 것들은 지역멤버라고 한다. (지역 밖에서는 사용불가)
    void lMethod(){
        class lClass{
            String lV;
            void lMethod(){

            }
        }//lClass
        Test test1 = new Test();
        test1.lMethod();

        lClass lclass = new lClass();
        lclass.lV = "what is this";
        lclass.lMethod();
    }//lMethod()

    int lMethod2(){     // return 은 모든 내가 아는 것들이 올 수 있음.
        class lClass{   // 메소드는 메소드가 끝나고 나서 내부에 있는 모든 것들을 메모리에서 비움.
            int a, b;   // 따라서 메소드가 실행되고 나서 결과를 받고싶다면 반드시 return이 필요하다.
        }//lClass
        lClass lc = new lClass();
        lc.a = 10;
        lc.b = 20;
        return lc.a + lc.b;
    }//lMethod2()
}//Test
