package Thread;

public class homework {
    public static void main(String[] args) {
        System.out.println("共有10000張高鐵票");
        ticketClass t1 = new ticketClass("售票機1");
        ticketClass t2 = new ticketClass("售票機2");
        ticketClass t3 = new ticketClass("售票機3");
        ticketClass t4 = new ticketClass("售票機4");
    }
    
}

class ticketClass implements Runnable{
    static int ticket = 10000;
    int sell_ticket;
    Thread t;

    ticketClass(String name){
        sell_ticket = 0; //機台賣的票券數量
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        int num;
        while((num = grabGold()) > 0){
            sell_ticket += num;
        }
        System.out.println(t.getName()+"總共賣了"+sell_ticket+"張票");
    }

    private synchronized static int grabGold(){
        if(ticket > 0){
            int need = (int)(Math.random() * 4) + 1;
            ticket -= need;
            return need;
        }
        return 0;
    }
}