public class QuickFindUF {

    int id[];
    int count; // no. of connected componenets

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {

        int pid = id[p];
        int qid = id[q];

        if (pid == qid) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
}
