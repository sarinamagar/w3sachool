public class Brackets {
    String brackets = "{()}";


    public void balancedBrackets(String brackets){
//        System.out.println(brackets.length()%2==0);
        String openingBrackets = "[{(";
        String closingBrackets = "]})";
        if(brackets.length()%2==0){
            for (int i=0; i<=brackets.length();i++){
//                System.out.println(i);
                System.out.println(brackets.indexOf("}"));
            }
        }
    }

    public static void main(String[] args) {
        Brackets check = new Brackets();
        check.balancedBrackets(check.brackets);
    }
}
