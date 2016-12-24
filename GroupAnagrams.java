/*
*Given an array of strings, group anagrams together.
*
*For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
*Return:
*
*[
* ["ate", "eat","tea"],
*  ["nat","tan"],
*  ["bat"]
*]
*/


public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ana = new HashMap();
        List<List<String>> list = new ArrayList();
        for(int i=0;i<strs.length;i++){
            char c[] = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(ana.get(s)==null){
                ana.put(s,new ArrayList());
                ana.get(s).add(strs[i]);
            }
            else{
                ana.get(s).add(strs[i]);
            }
        }
        Iterator it = ana.keySet().iterator();
        while(it.hasNext()){
            list.add(ana.get((String)it.next()));
        }
        return list;
    }
}
