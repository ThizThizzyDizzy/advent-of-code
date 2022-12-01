package aoc2021;
import java.math.BigInteger;
import java.util.HashMap;
public class Day14 implements Day{
    @Override
    public void run(){
        String input = """
                       OFSVVSFOCBNONHKFHNPK
                       
                       HN -> C
                       VB -> K
                       PF -> C
                       BO -> F
                       PB -> F
                       OH -> H
                       OB -> N
                       PN -> O
                       KO -> V
                       CK -> V
                       FP -> H
                       PC -> V
                       PP -> N
                       FN -> N
                       CC -> F
                       FC -> N
                       BP -> N
                       SH -> F
                       NS -> V
                       KK -> B
                       HS -> C
                       NV -> N
                       FO -> B
                       VO -> S
                       KN -> F
                       SC -> V
                       NB -> H
                       CH -> B
                       SF -> V
                       NP -> V
                       FB -> P
                       CV -> B
                       PO -> P
                       SV -> P
                       OO -> V
                       PS -> C
                       CO -> N
                       SP -> B
                       KP -> H
                       KH -> S
                       KS -> S
                       NH -> K
                       SS -> P
                       PV -> P
                       KV -> V
                       ON -> N
                       BS -> C
                       HP -> K
                       SB -> P
                       VC -> B
                       HB -> N
                       FS -> V
                       VP -> K
                       BB -> N
                       FK -> S
                       CS -> P
                       SO -> F
                       HF -> F
                       VV -> C
                       BC -> S
                       SN -> K
                       KB -> H
                       BN -> H
                       HO -> S
                       KC -> F
                       CP -> S
                       HC -> S
                       OS -> K
                       NK -> N
                       BF -> S
                       VN -> B
                       SK -> K
                       HV -> B
                       KF -> H
                       FV -> B
                       VF -> H
                       BH -> S
                       NN -> O
                       HH -> K
                       CN -> H
                       PH -> V
                       NF -> S
                       OV -> P
                       OC -> V
                       OK -> H
                       OF -> H
                       HK -> N
                       FH -> P
                       BK -> N
                       VS -> H
                       NO -> V
                       VK -> K
                       CF -> N
                       CB -> N
                       NC -> K
                       PK -> B
                       VH -> F
                       FF -> C
                       BV -> P
                       OP -> K""";
        System.out.println("Part one");
        String str = input.split("\n\n")[0];
        HashMap<String, String> recipes = new HashMap<>();
        for(String recipe : input.split("\n\n")[1].split("\n")){
            recipes.put(recipe.substring(0, 2), recipe.substring(6));
        }
        for(int i = 0; i<10; i++){
            for(int x = 0; x<str.length()-1; x++){
                String in = str.substring(x, x+2);
                if(recipes.containsKey(in)){
                    str = str.substring(0, x+1)+recipes.get(in)+str.substring(x+1);
                    x++;
                }
            }
        }
        HashMap<Character, Integer> counts = new HashMap<>();
        for(char c : str.toCharArray()){
            counts.put(c, counts.getOrDefault(c, 0)+1);
        }
        long min = -1, max = -1;
        for(Character c : counts.keySet()){
            if(min==-1||counts.get(c)<min)min = counts.get(c);
            if(max==-1||counts.get(c)>max)max = counts.get(c);
        }
        System.out.println(max-min);
        System.out.println("Part two");
        str = input.split("\n\n")[0];
        {
            HashMap<String, Long> pairs = new HashMap<>();
            HashMap<String, Long> elems = new HashMap<>();
            elems.put(str.charAt(0)+"", 1l);
            for(int x = 0; x<str.length()-1; x++){
                String in = str.substring(x, x+2);
                pairs.put(in, pairs.getOrDefault(in, 0l)+1);
                elems.put(in.substring(1), elems.getOrDefault(in.substring(1), 0l)+1);
            }
            for(int i = 0; i<40; i++){
                HashMap<String, Long> newpairs = new HashMap<>(pairs);
                for(String recipe : recipes.keySet()){
                    long count = pairs.getOrDefault(recipe, 0l);
                    String newElem = recipes.get(recipe);
                    elems.put(newElem, elems.getOrDefault(newElem, 0l)+count);
                    newpairs.put(recipe, newpairs.getOrDefault(recipe, 0l)-count);
                    String pair1 = recipe.charAt(0)+newElem;
                    newpairs.put(pair1, newpairs.getOrDefault(pair1, 0l)+count);
                    String pair2 = newElem+recipe.charAt(1);
                    newpairs.put(pair2, newpairs.getOrDefault(pair2, 0l)+count);
                }
                pairs = newpairs;
            }
            min = -1;
            max = -1;
            for(String s : elems.keySet()){
                if(min==-1||elems.get(s)<min)min = elems.get(s);
                if(max==-1||elems.get(s)>max)max = elems.get(s);
            }
            System.out.println(max-min);
        }
//        {
//            HashMap<String, BigInteger> pairs = new HashMap<>();
//            HashMap<String, BigInteger> elems = new HashMap<>();
//            elems.put(str.charAt(0)+"", BigInteger.ONE);
//            for(int x = 0; x<str.length()-1; x++){
//                String in = str.substring(x, x+2);
//                pairs.put(in, pairs.getOrDefault(in, BigInteger.ZERO).add(BigInteger.ONE));
//                elems.put(in.substring(1), elems.getOrDefault(in.substring(1), BigInteger.ZERO).add(BigInteger.ONE));
//            }
//            for(int i = 0; i<40; i++){
//                HashMap<String, BigInteger> newpairs = new HashMap<>();
//                HashMap<String, BigInteger> newelems = new HashMap<>();
//                for(String recipe : recipes.keySet()){
//                    BigInteger count = pairs.getOrDefault(recipe, BigInteger.ZERO);
//                    String newElem = recipes.get(recipe);
//                    elems.put(newElem, elems.getOrDefault(newElem, BigInteger.ZERO).add(count));
//                    pairs.put(recipe, BigInteger.ZERO);
//                    String pair1 = recipe.charAt(0)+newElem;
//                    pairs.put(pair1, pairs.getOrDefault(pair1, BigInteger.ZERO).add(count));
//                    String pair2 = newElem+recipe.charAt(1);
//                    pairs.put(pair2, pairs.getOrDefault(pair2, BigInteger.ZERO).add(count));
//                }
//            }
//            BigInteger bmin = null;
//            BigInteger bmax = null;
//            for(String s : elems.keySet()){
//                if(bmin==null||elems.get(s).compareTo(bmin)<0)bmin = elems.get(s);
//                if(bmax==null||elems.get(s).compareTo(bmax)>0)bmax = elems.get(s);
//            }
//            System.out.println(bmax.subtract(bmin));
//        }
    }
}