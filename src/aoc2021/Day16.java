package aoc2021;
import java.util.ArrayList;
public class Day16 implements Day{
    @Override
    public void run(){
        String input = "0052E4A00905271049796FB8872A0D25B9FB746893847236200B4F0BCE5194401C9B9E3F9C63992C8931A65A1CCC0D222100511A00BCBA647D98BE29A397005E55064A9DFEEC86600BD002AF2343A91A1CCE773C26600D126B69D15A6793BFCE2775D9E4A9002AB86339B5F9AB411A15CCAF10055B3EFFC00BCCE730112FA6620076268CE5CDA1FCEB69005A3800D24F4DB66E53F074F811802729733E0040E5C5E5C5C8015F9613937B83F23B278724068018014A00588014005519801EC04B220116CC0402000EAEC03519801A402B30801A802138801400170A0046A800C10001AB37FD8EB805D1C266963E95A4D1A5FF9719FEF7FDB4FB2DB29008CD2BAFA3D005CD31EB4EF2EBE4F4235DF78C66009E80293AE9310D3FCBFBCA440144580273BAEE17E55B66508803C2E0087E630F72BCD5E71B32CCFBBE2800017A2C2803D272BCBCD12BD599BC874B939004B5400964AE84A6C1E7538004CD300623AC6C882600E4328F710CC01C82D1B228980292ECD600B48E0526E506F700760CCC468012E68402324F9668028200C41E8A30E00010D8B11E62F98029801AB88039116344340004323EC48873233E72A36402504CB75006EA00084C7B895198001098D91AE2190065933AA6EB41AD0042626A93135681A400804CB54C0318032200E47B8F71C0001098810D61D8002111B228468000E5269324AD1ECF7C519B86309F35A46200A1660A280150968A4CB45365A03F3DDBAE980233407E00A80021719A1B4181006E1547D87C6008E0043337EC434C32BDE487A4AE08800D34BC3DEA974F35C20100BE723F1197F59E662FDB45824AA1D2DDCDFA2D29EBB69005072E5F2EDF3C0B244F30E0600AE00203229D229B342CC007EC95F5D6E200202615D000FB92CE7A7A402354EE0DAC0141007E20C5E87A200F4318EB0C";
        System.out.println("Part one");
        Packet packet = hexPacket(input);
        System.out.println(packet.versionSum());
        System.out.println("Part two");
        System.out.println(packet.value());
    }
    public Packet hexPacket(String hex){
        String bin = "";
        for(char c : hex.toCharArray()){
            String b = Integer.toBinaryString(Integer.parseInt(c+"", 16));
            while(b.length()<4)b = "0"+b;
            bin+=b;
        }
        return new Packet(bin);
    }
    private static class Packet{
        int version, type;
        private String text;
        private int bitsConsumed = 0;
        private long value;
        private ArrayList<Packet> subpackets = new ArrayList<>();
        public Packet(String bin){
            text = bin;
            version = Integer.parseInt(bits(3), 2);
            type = Integer.parseInt(bits(3), 2);
            if(type==4){//parse literal
                String valS = "";
                String start;
                do{
                    start = bits(1);
                    valS+=bits(4);
                }while(start.equals("1"));
                value = Long.parseLong(valS, 2);
//                chop();
            }else{//parse operator
                int lengthType = bits(1).equals("1")?1:0;
                if(lengthType==0){
                    int length = Integer.parseInt(bits(15), 2);
                    String subpacks = bits(length);
                    while(!subpacks.isEmpty()){
                        Packet packet;
                        subpackets.add(packet = new Packet(subpacks));
                        subpacks = subpacks.substring(packet.bitsConsumed);
                    }
                }
                if(lengthType==1){
                    int numPackets = Integer.parseInt(bits(11), 2);
                    for(int i = 0; i<numPackets; i++){
                        Packet packet;
                        subpackets.add(packet = new Packet(text));
                        bits(packet.bitsConsumed);
                    }
                }
            }
        }
        public int versionSum(){
            int sum = version;
            for(Packet p : subpackets)sum+=p.versionSum();
            return sum;
        }
        private String bits(int count){
            bitsConsumed+=count;
            String ret = text.substring(0, count);
            text = text.substring(count);
            return ret;
        }
        private void chop(){
            int toChop = bitsConsumed;
            while(toChop>0)toChop-=4;
            bits(-toChop);
        }
        private long value(){
            switch(type){
                case 0 -> {
                    long val = 0;
                    for(Packet p : subpackets){
                        val+=p.value();
                    }
                    return val;
                }
                case 1 -> {
                    long val = 1;
                    for(Packet p : subpackets){
                        val*=p.value();
                    }
                    return val;
                }
                case 2 -> {
                    long val = Long.MAX_VALUE;
                    for(Packet p : subpackets){
                        val = Math.min(val, p.value());
                    }
                    return val;
                }
                case 3 -> {
                    long val = Long.MIN_VALUE;
                    for(Packet p : subpackets){
                        val = Math.max(val, p.value());
                    }
                    return val;
                }
                case 4 -> {
                    return value;
                }
                case 5 -> {
                    return subpackets.get(0).value()>subpackets.get(1).value()?1:0;
                }
                case 6 -> {
                    return subpackets.get(0).value()<subpackets.get(1).value()?1:0;
                }
                case 7 -> {
                    return subpackets.get(0).value()==subpackets.get(1).value()?1:0;
                }
            }
            throw new IllegalArgumentException("Invalid type!");
        }
    }
}