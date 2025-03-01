import unit4.collectionsLib.BinNode;

public class targil_arr {
    public static void main (String[]args){
        BinNode<Integer> list = createList(5);
        printToRight(list);


    }
    public static BinNode<Integer> createList(int n) {
        BinNode<Integer> h = null;
        // задание: сделай лист от 1 до n
        if (n > 0) {
            BinNode<Integer> tmp = null;
            BinNode<Integer> p = null;

            for (int i = 1; i <= n; i++) {
                if (h == null) {
                    h = new BinNode<Integer>(i);
                    tmp = h;
                } else {
                    p = new BinNode<Integer>(i);
                    tmp.setRight(p);
                    p.setLeft(tmp);
                    tmp = p;
                }
            }
        }
        return h;
    }

    public static void printToRight(BinNode<Integer> h) {
        BinNode<Integer> tmp = null;

        for (tmp = h; tmp != null; tmp = tmp.getRight()) {
            System.out.printf(tmp.getValue() + " ");
        }
       // System.out.println();
    }

    public static void printToLeft(BinNode<Integer> h) {
        BinNode<Integer> tmp = null;
        for (tmp = h; tmp != null && tmp.getRight() != null; tmp = tmp.getRight()) ;
        for (; tmp != null; tmp = tmp.getLeft())
            System.out.printf(tmp.getValue() + " ");
    }


    public static void addNode(BinNode<Integer> h,
                               BinNode<Integer> p, int n) {
        BinNode<Integer> tmp = null;
        BinNode<Integer> current = null;

        if (h == null) {
            h = new BinNode<Integer>(n);
        } else {
            if (p == null) {
                p = new BinNode<Integer>(n);
                p.setRight(h);
                h.setLeft(p);
                h = p;
            } else {

            }
        }


    }


}
