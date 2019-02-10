public class WeightedQuickUnionUF {

    int parent[];
    int size[];
    int count ;

    public WeightedQuickUnionUF(int N) {
        count =N ;
        for(int i=0;i<N;i++) {
            parent[i] = i;
            size[i] =1;
        }
    }

    public int root(int p) {
        while(p!=parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public void  union(int p , int q) {
        int proot = root(p);
        int qroot = root(q);

        if(proot == qroot) return;

        if(size[proot] < size[qroot]) {
            parent[proot] = qroot;
            size[qroot] += size[proot];
        }
        else {
            parent[qroot] = proot;
            size[proot] += size[qroot];
        }
        count--;
    }
}
