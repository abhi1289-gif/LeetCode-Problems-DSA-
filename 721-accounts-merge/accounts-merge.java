class Solution {

    public int find(int node, int[] parent) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node], parent);
    }

    public void unite(int a, int b, int[] parent) {

        int parA = find(a, parent);
        int parB = find(b, parent);

        if (parA != parB) {
            parent[parA] = parB;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> nums) {
        HashMap<String, Integer> emailToNameIdx = new HashMap<>();

        int parent[] = new int[nums.size()];
        for(int i=0; i<nums.size(); i++) parent[i] = i;

        for(int i=0; i<nums.size(); i++){
            for(int j=1; j<nums.get(i).size(); j++){
                String email = nums.get(i).get(j);

                if(emailToNameIdx.containsKey(email)){
                    int par = emailToNameIdx.get(email);
                    unite(i, par, parent);
                }
                else{
                    emailToNameIdx.put(email, i);
                }
            }
        }

        HashMap<Integer, List<String>> nameToEmail = new HashMap<>();

        for(String email: emailToNameIdx.keySet()){
            int a = emailToNameIdx.get(email);
            int par = find(a, parent);
            if(!nameToEmail.containsKey(par)) nameToEmail.put(par, new ArrayList<>());
            nameToEmail.get(par).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int idx: nameToEmail.keySet()){
            List<String> temp = nameToEmail.get(idx);
            Collections.sort(temp);
            List<String> list = new ArrayList<>();
            list.add(nums.get(idx).get(0));
            list.addAll(temp);

            ans.add(list);
        }
        ans.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        return ans;
    }
}