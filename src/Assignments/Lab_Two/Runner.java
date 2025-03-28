package Assignments.Lab_Two;

public class Runner {
    public static void main(String[] args) {
        callCenterManagement ccm = new callCenterManagement();

        ccm.addCall(101, "first call");
        ccm.addCall(102, "second call");

        ccm.displayCalls();
        ccm.processCall();
        ccm.processCall();


        System.out.println();

        ccm.displayHistory();
    }
}
