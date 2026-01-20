class PrintJob implements Runnable {

    private String documentName;

    PrintJob(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public void run() {
        System.out.println(
            "Printing " + documentName + 
            " by " + Thread.currentThread().getName()
        );
    }

    public static void main(String[] args) {

        PrintJob job1 = new PrintJob("Resume.pdf");
        PrintJob job2 = new PrintJob("Report.docx");
        PrintJob job3 = new PrintJob("Invoice.xls");

        Thread t1 = new Thread(job1);
        Thread t2 = new Thread(job2);
        Thread t3 = new Thread(job3);

        t1.start();
        t2.start();
        t3.start();
    }
}
