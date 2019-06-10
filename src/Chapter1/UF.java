package Chapter1;

// quick find的问题是 归并需要遍历数组 访问操作过多
// quick union的问题是 find的操作可能会访问到深度是数组长度的树 导致数组访问次数过多
// 所以对quick union的优化是加权记录每棵树的深度
// 值得注意的是, 优化是针对下一次访问树的过程, 因为树不像quick union那样, 会变得那么深了
public class UF {
    public enum UF_TYPE{
        QUICK_FIND,
        QUICK_UNION,
        WEIGHT_QUICK_UNION,
    }

    private int[] id;
    private int count;
    private int[] sz;
    private UF_TYPE ufType;

    public UF(int N){
        count = N;

        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        switch (ufType) {
            case QUICK_FIND:
                unionQuickFind(p, q);
                break;
            case QUICK_UNION:
                unionQuickUnion(p, q);
                break;
            case WEIGHT_QUICK_UNION:
                unionWeightQuickUnion(p, q);
                break;
            default:
                break;
        }
    }

    public int find(int p) {
        switch (ufType) {
            case QUICK_FIND:
                return findQuickFind(p);
            case QUICK_UNION:
                return findQuickUnion(p);
            default:
                return -1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public void setUfType(UF_TYPE type) {
        this.ufType = type;
    }

    private void unionQuickFind(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }

        count--;
    }

    private void unionQuickUnion(int p, int q) {
        // quick union
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }

    private void unionWeightQuickUnion(int p, int q) {
        // weight quick union
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += qRoot;
        }
        count--;
    }

    private int findQuickFind(int p) {
        // quick find
        return id[p];
    }

    private int findQuickUnion(int p) {
        // quick union && weight quick union
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }
}
