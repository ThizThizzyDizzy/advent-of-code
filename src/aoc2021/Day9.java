package aoc2021;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Day9 implements Day{
    public ArrayList<Basin> basins = new ArrayList<>();
    private int[][] heightmap;
    @Override
    public void run(){
        String input = "9899899864598765321239999546794323489012356910136789234678999765986432109874349897678921298754345856\n" +
"8798788978989899992398798932986734678943869872345679129789999843497643298765456789568910129983236745\n" +
"7676567899976998789977587891297945789654699964557789298999987932599954399897897893457891239765101234\n" +
"6545459789765497679765476789349657898765789985668999987899876893989876988998998932378932349874323457\n" +
"6435345678987984568974345678998998999997893596779789876789765689878989877569789949989864556995434567\n" +
"4323234799999876789743234789997899990199952129895698975678934599769998966445679897899876769876546789\n" +
"3210125899989987897654348999876789989987641016954987654699545678958986543234598786788989895989657899\n" +
"4391434989878999998776567898765434878999832345693198766789956799346995432123987655677899934598978978\n" +
"5989549876567899899987898997654323459876546598789239979899897890239876543099878434566789545987899769\n" +
"9878998765456789788798999998765434568997687678898945989999789994345987654987654312345689656976793244\n" +
"9767989654345897652649999899876685678998798899987899995697679879959998765699873201239798769865692123\n" +
"8656976543234789341234987676987899899219999912345678934987599767898999978798765412345689898764789045\n" +
"9947987654375693210359876565499999931929898924569789875699987659946792499899886643459898999893492123\n" +
"9858998765466789391398765454346789649898767895798999997893987548937921398965998754567987897632459234\n" +
"8769879876879899989989764321234698798789656896897689889902998437898943497994339867899986796543678945\n" +
"9897765989989999867879865430126789987654546789989549778919876545999654986789123979999765689954567956\n" +
"9976544393499987853467954321245678998793235678965434567924998656998965987991094989998654578899778998\n" +
"9999932239599876542346986434358789899986545689876545679895698787897896799432989999987943348799889999\n" +
"8987890198989987621234976565469896799998676896987656996789789898956789898549878909876821234589997891\n" +
"7896991987678998210123989679578935678999787965498899875678999989545789987699868912985310345678956932\n" +
"6545689998899879321234598798689323489899898978309987664567899975434699998989957899976431458999349893\n" +
"5434578999998765442456679899799912398789959793212986543446798766323578949879898998997643467921236789\n" +
"4323467899989887663567889979899893987664234689323985431234579654212349939765789987698754567890945699\n" +
"3214347999876998898779998765998789998543123456939876420256689799903467897654579876569866678999899789\n" +
"4301236897654459989899659984345678987655234597899987834569798987894979996543456987456978789298798999\n" +
"3213345789542345678978939873234789398976349989999998945678987676569899987632169876345989892197696989\n" +
"5624567899643456789568998764566991299987898767998999987989986543456789198721098765456799943987575878\n" +
"5438678978954567895478679875678992989998939654767899999899976432345899239433679899587899656943434567\n" +
"6648789367896788901234567987789889879899029953459987899769865431235678945954567998679978969832123458\n" +
"9859895456789899212349678999898776768799998764567896988998765610123479959895979989989967898751012345\n" +
"9967997667899954324568989789999654356679879985778934567899654321234567896789898978997856987632123456\n" +
"9878998789999876535679495698998743244598965797899323456998767434345798965698767869896549876543478567\n" +
"2989899899999987646789323457987653123697854698965414568959876545756799454987655456789659987754569678\n" +
"1095798998989899756793212568999761019986543569876501278945987767867895323986542345678978998978678899\n" +
"2124567897679789868965425799999832198765432479987612378929898989978976568997721239899989539989789999\n" +
"3236678998554678979996934989987543239874321389998724567998769694989989679999843345789894312999895689\n" +
"4545699965433459989989899976797654647989433479999837678909654543295798797899756789898765109876954799\n" +
"5666789876212567899876798765698987656897654567892948789219763210134569896798767991949966212965432878\n" +
"9877899998434678998555679954459898768998765789910959898923987321949698965329878910123954329896421267\n" +
"5989999997565789997434567892346789878919878894329878987894596439898997643201989543239865498765432349\n" +
"4399998998776899876723478921234567989329989999456989656789989598797689764312399654345986569989643578\n" +
"1299897679897939765434589210565699995498797998968996546789679987654578975323478965696798679698754689\n" +
"2989788567998929876547895342456988976987656877989965432433567976543459987634569996989899889579965691\n" +
"9976543456899998987656789756769876799876546766899876541012456798952348998545678989878954993499876792\n" +
"8765432337899987698767899897898765689985432345789987632323577899891276789789989878767893212988989893\n" +
"9875430123789976569898945989999854578997643487892398743439688998789345689899998765456789329776598954\n" +
"9965321934567895452959999878987543567898797698990129965998999987678956789998987654349899998665456895\n" +
"9875439899998954321234988768987654678999898979789249879867899876598967899987598985269989876542347896\n" +
"6986598798789865632459876543298765889899989563678956998756998765456978999876459876378978965431238987\n" +
"5597989587678978643598995432139876998798765472489767987645797654327899998764323987889769896670123598\n" +
"4459965454597897659987689321025987998679977321238989998434589765458954987643212498997656795431245789\n" +
"2398854323456989798776567992134699876468893210137999987514678976579763296543101359894245695432356897\n" +
"1987643412345678939654467689657899884245789543236789987623569989697654197653212346792136789565456795\n" +
"2498532101246989549743234578968998762136898654345698765434678999789765298894343478891017899877567896\n" +
"3987643212397999959832175999878999754547899865466789987545789567996978349965454567892128998987688987\n" +
"4998784323498999899943567899989398767898999989877995998766893459545989459876565678943469876898999798\n" +
"9859897654679987799654678967895459898919498694989234889877965667934696567989876789656778965569899659\n" +
"8743998767899866698769899345989969999902397543992125679989878799323597689999987898767889654398788945\n" +
"9632349878998754569889943239879898997893598679875234567897999989434698799989698989898999965235667896\n" +
"6531267989989986678997632198767767896789989789994345789976567978965699899978559678999987892123456789\n" +
"7545459899878998789898543986553656789899879897989976789987699869998789998765432568990196789014567891\n" +
"7656797658768899894698754965432348999998765956978987998798987658789892399986543479989985698925678992\n" +
"8769989545656789923999869876521234689998754349869898997679799645679901989987756569876674567896999989\n" +
"9898978934345679899897998765420127899976543209655789876567697536796899878999867898985543456789878978\n" +
"9997657921234698789656789876431236789898754498743678975434598987895679767899879987654102345678966466\n" +
"8987546892945987678945678987654345698789865999654569876545679799934698654568992976543212456789854345\n" +
"7895435789896976567998789998765456789679979898785678997697989689996789763499201987954323589898763234\n" +
"6796576798789895456899899989876577894578998789876899789989993498989899852178919998765454678997654346\n" +
"5987678987676789345901939876987689923489987654987987698778921397878989943267898999986869789039766467\n" +
"4599999876575689234899029965499897634590976543499996545567892986565679894356997896897999892123978578\n" +
"3459898765434590135678998764345976545692985432459896532346979875434598789459876785698989993239899989\n" +
"2599749854325679246999569878967989656789987653498789431234567994323987689998765834569878989398789992\n" +
"1987630965434994356789479989878998787896599765987678932345679765509876567899954323498769878987678891\n" +
"9999521398946789969892398995989999898965439899876567894467989876798765458998763214987654567898546789\n" +
"8998432987656899899901987854699987999654323934985458965678999987987654367959984523986543456789434899\n" +
"7987674598967958789319876543598996598743209129994346899899019998998765488945965439876431345678924997\n" +
"5499789679878945689498765432387897679654998998789235679999198999879896569239876567989642456789213456\n" +
"9329898789989235578999878541266799998769876987698945791098987898965987892123987678998753768995101234\n" +
"8910959895490123467899999320145987899898765976587997892397596987654998999934999789989967989654312689\n" +
"7892345986321434678978989431239986989987654989456789989996465698789869898899889898879878998765424578\n" +
"6996456795432375679767978932398895878996432198568999878789324249898756797765678987666989129987435699\n" +
"5979677986545699897659867893987674567987643987678968965679210136999645975654457896544598998976546989\n" +
"4367999987656988976543956895698543467998754599889757894568921245695439984323298989323567897987659878\n" +
"3246798998789867897432348986987674578979895789997645953457999356976698793210129678912378976498798767\n" +
"2124687899898756789321467999898765689357987899898756892345678968998997654323234567924459765349987656\n" +
"1012456923987645995436578987789876791268998989769878954596789989459898969864347979895689921234596545\n" +
"2423677899999766898656679876565987892379129678945989965678992191298769798765456798789789890145985434\n" +
"7634988998919878998787899985434598943468934589959999876899321019497653669986599987678998789959876515\n" +
"8795999687909989999998999875323459976567896799898921989987432198976442456797987876589998679899987601\n" +
"9989896545798998989659298765435678997878987899767899898976543987664321345679976565456895466789998312\n" +
"9878789434567897878943019876546899898989098987656965787987674976543210146798765434345689345679876543\n" +
"9965678923456996567932129987656998779692199998767893656899895698956343234999875323239791236799987654\n" +
"9876799544799987459543298598998999657569987999898912345678976989765464349878974210178943478989899785\n" +
"0999898765678942378954997459679996545498876891959101234567899878999878498769865323367894569876799876\n" +
"1298999898799865489769876323589989432397545790943212345678998967889989998659876554459965679965587997\n" +
"2997899939894987999878965104678978921239834899865623456789987654378999867543987678767897898743456898\n" +
"9876789921923999899999874324989867890398765689976784568891298763254987658902398789879998987652345999\n" +
"7665567890199895679765965449898756789459876789987896878932459542123496543212479893989459876541256899\n" +
"8543458932987684567964987598765435678968997895398987989656899643234569854324569912995312997632345789\n" +
"7652369543498543678932197679886545799878998943219998999768998754545698765537678929876109876543467899";
        System.out.println("Part one");
        String[] splinput = input.split("\n");
        int[][] heightmap = new int[splinput[0].length()][splinput.length];
        for(int y = 0; y<splinput.length; y++){
            String row = splinput[y];
            for(int x = 0; x<row.length(); x++){
                int val = Integer.parseInt(row.charAt(x)+"");
                heightmap[x][y] = val;
            }
        }
        int risk = 0;
        for(int x = 0; x<heightmap.length; x++){
            FOR:for(int y = 0; y<heightmap[x].length; y++){
                ArrayList<Integer> vals = new ArrayList<>();
                if(y>0)vals.add(heightmap[x][y-1]);
                if(x>0)vals.add(heightmap[x-1][y]);
                if(x<heightmap.length-1)vals.add(heightmap[x+1][y]);
                if(y<heightmap[x].length-1)vals.add(heightmap[x][y+1]);
                int val = heightmap[x][y];
                for(int i : vals){
                    if(i<=val)continue FOR;
                }
                risk+=val+1;
            }
        }
        System.out.println(risk);
        System.out.println("Part two");
        this.heightmap = heightmap;
        for(int x = 0; x<heightmap.length; x++){
            FOR:for(int y = 0; y<heightmap[x].length; y++){
                Basin basin = getBasin(x, y);
                if(basin==null)continue;
                if(!basins.contains(basin))basins.add(basin);
            }
        }
        Collections.sort(basins, (b1, b2)->{
            return b2.positions.size()-b1.positions.size();
        });
        System.out.println(basins.get(0).positions.size()*basins.get(1).positions.size()*basins.get(2).positions.size());
    }
    public Basin getBasin(int x, int y){
        if(heightmap[x][y]==9)return null;
        for(Basin basin : basins){
            if(basin.contains(x, y))return basin;
        }
        return new Basin(x, y);
    }
    public class Basin{
        public ArrayList<int[]> positions = new ArrayList<>();
        public Basin(int x, int y){
            positions.addAll(toList(getBasinPositions(x, y)));
        }
        public boolean contains(int x, int y){
            for(int[] pos : positions)if(pos[0]==x&&pos[1]==y)return true;
            return false;
        }
    }
    private HashMap<Integer, ArrayList<int[]>> getBasinPositions(int startX, int startY){
        //layer zero
        HashMap<Integer, ArrayList<int[]>>results = new HashMap<>();
        ArrayList<int[]> zero = new ArrayList<>();
        zero.add(new int[]{startX, startY});
        results.put(0, zero);
        //all the other layers
        int maxDistance = heightmap.length*heightmap[0].length;//the algorithm requires a max search distance. Rather than changing that, I'll just be lazy and give it a big enough number
        for(int i = 0; i<maxDistance; i++){
            ArrayList<int[]> layer = new ArrayList<>();
            ArrayList<int[]> lastLayer = new ArrayList<>(results.get(i));
            if(i==0&&lastLayer.isEmpty()){
                lastLayer.add(new int[]{startX,startY});
            }
            for(int[] block : lastLayer){
                FOR:for(int j = 0; j<4; j++){
                    int dx=0,dy=0;
                    switch(j){//This is a primitive version of the Direction class used in other places here, but I'll just leave it as it is
                        case 0:
                            dx = -1;
                            break;
                        case 1:
                            dx = 1;
                            break;
                        case 2:
                            dy = -1;
                            break;
                        case 3:
                            dy = 1;
                            break;
                        default:
                            throw new IllegalArgumentException("How did this happen?");
                    }
                    int newX = block[0]+dx;
                    int newY = block[1]+dy;
                    if(newX<0||newY<0||newY>=heightmap.length||newX>=heightmap[0].length)continue;
                    if(heightmap[newX][newY]==9)continue;
                    for(int[] oldPos : lastLayer){//if(lastLayer.contains(newint[]))continue;//if the new block is on the same layer, ignore
                        if(oldPos[0]==newX&&oldPos[1]==newY){
                            continue FOR;
                        }
                    }
                    if(i>0){
                        for(int[] oldPos : results.get(i-1)){//if(i>0&&results.get(i-1).contains(newint[]))continue;//if the new block is on the previous layer, ignore
                            if(oldPos[0]==newX&&oldPos[1]==newY){
                                continue FOR;
                            }
                        }
                    }
                    for(int[] oldPos : layer){//if(layer.contains(newint[]))continue;//if the new block is on the next layer, but already processed, ignore
                        if(oldPos[0]==newX&&oldPos[1]==newY){
                            continue FOR;
                        }
                    }
                    layer.add(new int[]{newX,newY});
                }
            }
            if(layer.isEmpty())break;
            results.put(i+1, layer);
        }
        return results;
    }
    private static ArrayList<int[]> toList(HashMap<Integer, ArrayList<int[]>> blocks){
        ArrayList<int[]> list = new ArrayList<>();
        for(int i : blocks.keySet()){
            list.addAll(blocks.get(i));
        }
        return list;
    }
}