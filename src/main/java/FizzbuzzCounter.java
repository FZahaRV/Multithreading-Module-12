
class FizzbuzzCounter {
    Thread A = new Thread(this::fizz);
    Thread B = new Thread(this::buzz);
    Thread C = new Thread(this::fizzbuzz);
    Thread D = new Thread(this::number);
    private String[] fizzbuzzArray;
    public void fizzbuzzCounter(int n) throws InterruptedException {
        fizzbuzzArray = new String[n];
        for (int i = 0; i < n; i++) {
            fizzbuzzArray[i] = String.valueOf(i + 1);
        }
        A.start();
        B.start();
        C.start();
        D.start();

        A.join();
        B.join();
        C.join();
        D.join();
    }
    public void fizz() {
        for (int i = 2; i < fizzbuzzArray.length; i+=3){
            if ((i+1) % 3 == 0 && (i+1) % 5 != 0){ fizzbuzzArray[i] = "fizz";}
        }
    }
    public void buzz() {
        for (int i = 4; i < fizzbuzzArray.length; i+=5){
            if ((i+1) % 5 == 0 && (i+1) % 3 != 0) {fizzbuzzArray[i] = "buzz";}
        }
    }
    public void fizzbuzz() {
        for (int i = 0; i < fizzbuzzArray.length; i++){
            if ((i+1) % 5 == 0 && (i+1) % 3 == 0) {fizzbuzzArray[i] = "fizzbuzz";}
        }
    }
    public void number() {
        for (String str : fizzbuzzArray) {
            System.out.println(str);
        }
    }
}