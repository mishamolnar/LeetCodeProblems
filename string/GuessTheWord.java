package LeetCode.string;

import java.util.*;

//https://leetcode.com/problems/guess-the-word/submissions/
public class GuessTheWord {

        public void findSecretWord(String[] wordlist, Master master) {
            Random random = new Random();
            for(int i = 0, matches = 0; i < 10 && matches != 6; i ++){
                String guess = wordlist[random.nextInt(wordlist.length)];
                matches = master.guess(guess);
                List<String> candidates = new ArrayList<>();
                for(String word: wordlist){
                    if(matches == getMatches(guess, word)){
                        candidates.add(word);
                    }
                }

                wordlist = candidates.toArray(new String[0]);
            }
        }

        private int getMatches(String word1, String word2){
            int matches = 0;
            for(int i = 0; i < word1.length(); i ++){
                if(word1.charAt(i) == word2.charAt(i)){
                    matches ++;
                }
            }

            return matches;
        }



    public static void main(String[] args) {
        GuessTheWord guessTheWord = new GuessTheWord();
        guessTheWord.findSecretWord(new String[]{"eykdft","gjeixr","eksbjm","mxqhpk","tjplhf","ejgdra","npkysm","jsrsid","cymplm","vegdgt","jnhdvb","jdhlzb","sgrghh","jvydne","laxvnm","xbcliw","emnfcw","pyzdnq","vzqbuk","gznrnn","robxqx","oadnrt","kzwyuf","ahlfab","zawvdf","edhumz","gkgiml","wqqtla","csamxn","bisxbn","zwxbql","euzpol","mckltw","bbnpsg","ynqeqw","uwvqcg","hegrnc","rrqhbp","tpfmlh","wfgfbe","tpvftd","phspjr","apbhwb","yjihwh","zgspss","pesnwj","dchpxq","axduwd","ropxqf","gahkbq","yxudiu","dsvwry","ecfkxn","hmgflc","fdaowp","hrixpl","czkgyp","mmqfao","qkkqnz","lkzaxu","cngmyn","nmckcy","alpcyy","plcmts","proitu","tpzbok","vixjqn","suwhab","dqqkxg","ynatlx","wmbjxe","hynjdf","xtcavp","avjjjj","fmclkd","ngxcal","neyvpq","cwcdhi","cfanhh","ruvdsa","pvzfyx","hmdmtx","pepbsy","tgpnql","zhuqlj","tdrsfx","xxxyle","zqwazc","hsukcb","aqtdvn","zxbxps","wziidg","tsuxvr","florrj","rpuorf","jzckev","qecnsc","rrjdyh","zjtdaw","dknezk"}, new Master());
    }

    private static class Master {
        private int guess(String s) {
            String mach = "cymplm";
            int common = 0;
            for (int i = 0; i < 6; i++) {
                if (mach.charAt(i) == s.charAt(i)) common++;
            }
            if (common == 6) System.out.println("SNKJFNAANKJSFKJNSANKJASKNJDFAKJ L");
            return common;
        }
    }
}
