class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] str = sentence.split(" ");
        HashSet<String> set = new HashSet<>();
        for(String st : dictionary) set.add(st);
        
        for(int i=0; i<str.length; i++){
            String word = str[i];
            for(int j=1; j<=word.length(); j++){
                if(set.contains(word.substring(0, j))) {
                    str[i] = word.substring(0, j);
                    break;
                }
            }
        }
        StringBuffer sb = new StringBuffer("");
        sb.append(str[0]);
        for(int i=1; i<str.length; i++) sb.append(" "+str[i]);
        return sb.toString();
    }
}