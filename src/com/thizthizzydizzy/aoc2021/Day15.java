package com.thizthizzydizzy.aoc2021;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
public class Day15 implements Day{
    private static String input = """
                                  4644191171337732143712186124233573969322319997149343221542323211321212169142231235619969739483792471
                                  2221293392911371411593639962951141752813313921357129613938931533621918583683134152965492646642538116
                                  2795791297555313411382761825567331471819212315341825911232943151936415218119321513121916912261697597
                                  1214537613992125712382233916937264885938549131332876391646112221213144242126287714516436119191917362
                                  1412811515321221111439182464221331329974283623974241113548427128422112192118983384463232121843121141
                                  3245255675412351991191259591561111991221265214221291175137165299373379821323142951719393624496355173
                                  7821636439137114454815234184431131151885565811162122141111291739141236111319913333811111656913241523
                                  1418191421242372241523343828141122624329116111754397113548982293191411111144261229944124833111847376
                                  1415223811928588114168213319591148928517427169381184991691112118229218263638951854741122722159931213
                                  1185112211216296846141231621592158511243111111346117648971911331811279689234291837116151264761299521
                                  2157175132842918592376386235452686111324627214122733298544113111534712212591393262313832165437912113
                                  1116112493319299432145649149992697711725421154424224312213396977142985512232427326338299642149836196
                                  6549229499212395113283291496151231611431251843344129142294319947252811251219755391642553173113821296
                                  4113393621316222283852914519968238256112711138455548538191592324236277743141198979959471862712168221
                                  1741128134354414241419176117119212641541117881955126161946213118193312324857619874348283423325548598
                                  3751141123712163925113282172764932353534116546231281293118591422522113149152261498874515989313554314
                                  4514551971341761251629465312511329291978512148461991612957411327621224192111126296379215871233811481
                                  3293217144136116298991343111524616863893234462111723531219141172273261192421911186619159615299151135
                                  7774221151285219996117174373446146141833811666627831912921211686311331622326641123291596353856612959
                                  1351122214751889195351764143332617127231529144667721221129811142151686112447161472232912114911498432
                                  7225121617125257598871963211815844737221578124248727132498851251391513323133165922818784851344161916
                                  1112187345141297179198141512813725433119213925696911577227241222816471151855194112221672612468122119
                                  1121991355992132552111213132191442529433379222141737721118515814411171128371158391185211772681121151
                                  3611317119849285611931216381814841117111553118123151123429121933733781431918246438319192543378241244
                                  2216973154335197135211535821482816136121216777138722357726122631253431191217262219637112927427564151
                                  5191998411823118893385217392312149124881216981988142455391121911741599925291712131939112984622594162
                                  9512532169823462117945393432541745813525811441272984121112552932917817923383181475411441151349226821
                                  3411874821911569271324123211326163841991128122341482721111115399651299314699266658849911711231323912
                                  7694685861132348951471861817731787685615352753172139744392721512255361251492221911127122613845334296
                                  1113697413329171211439739511931411924968888839312278319759419239814972811121854533399269742318264862
                                  3261667141191721233392311941113633191795822122212119221174142635691755551245192319949176814814316991
                                  2128111325114212336337636612529217112293426976253814989893331386522713418281571915911922457712133131
                                  8388911376618344994992583184752685539238543959953246364821659122425889299729352751111921721511272199
                                  2122155921932542114611151421752127825727141198197413114255419142717265333392684821477226612894862559
                                  1951121655921881375819253119554413525181757211271911799915211551299921612352952113953924955851737855
                                  8195214285611188396611335793711117151312316188149873422613973825989185924514991359346339783843843334
                                  5456833919619253912174733996922156217884375932117373542943268995816113232121789731392898427391181116
                                  4777217181611414812166144323146981138677578415811253842294432341423919922422381614691619319263292673
                                  1871985126952132273312531611829113511331968253631512251863889446196571436982662319393312117814312223
                                  4144118646856288731789179912621365532752715112255935546128459221171311137762973879129462196861223341
                                  5331743126787154471212425952845476245991112234222998154272399175132112413123715171136641911131729182
                                  6459321122282315131822523312117117212329381828311268157731316333126392285181951389374121861573611883
                                  1129519121932136168211173395152156158311198521161721877242125629612171323591229332881655592295117452
                                  4341822521595939622189164981116331219261274132118781411796193741169311918311822217877764111699911254
                                  4194536129171715722286327511111124828745972271325116713569374751324429292311753151131516413241834449
                                  2654142945631129956123367481172912142744199122191626922239395112592217148883514168932621184272178615
                                  4157713294921232144519182476441189526311311114777342965936356951743225131121191824416924178512318511
                                  6912411821531292292181267613662222516132574199134177394148798111514136319121566731314235317164439911
                                  1437321155329217229142678137571111359263414123211224312882335825119927798139832929124119648129273158
                                  1732391818138229589491914619358266961163398213919395213291514999415122435132113734813288381419819249
                                  4113346921421917866111857654393412952122411689932611554121571489921198684193331141319469559362897418
                                  3936181514241719511931294342174121311321234132821683441143221627121222912219121123417289754991212193
                                  5231211979311961116116212251613682828181291627731949883315367221227411122625338116897436595199253162
                                  2316316823133527186851941188913312213143341419114417621723676119643866413111512137248492799272283874
                                  3119192116842719272523136623911313937534137524214481191735181477319325633146114939176412112636323417
                                  2492714192521612141248169319193626151911919321234131296181642619511212191466114432116195132659299995
                                  8479281136811514162331236428357598113492342253565417152872842112725149934866538744331141447117166111
                                  8119623422439216225228196551954272643443171919589198617821835123212386869188415911424183945151334241
                                  2441131613411116653297822116736662114797231228699315262527411234919279976921765231169112216112919848
                                  3831541198992925558534136856443141276992238182251969817995131132423277612211112197312711991832328931
                                  4857223123934311294131922752993114976915557976818181275728832322272499252323121313288171744324765443
                                  6288391134124416473924343716745649381453218212143281127971317811511748813199842175114288225452114924
                                  2198193117421166796123194192539312141215519112972453238891813111365441112114115347214113916577619519
                                  4829218134763351139297321322168924116121484533211291255719399319238352153167888261311881156385931422
                                  1128131518795612511811698671411951513233914459321461852952978173818789621743591166392521464181816178
                                  1238497511773695513118432223193651911824333381942211111917892631655191328368558712842618374164192141
                                  5197814252643194532182168116535512142118911412974122512425237539834313411221165712489961923581131921
                                  5911812939579518465461451173198646171335111185511687173891229811734589488111952535421341871929712588
                                  1671651526181764772599923144212312319733142231365158737371635371423522142829181192112264525227179493
                                  7421112826829293192119831269314941212923232123538851869151292117144743917691154582417433994491521943
                                  9191346716972561945245244324428371279373282126116111451618129133112293262414113689369614111711445421
                                  2316166312199999129455391528271939493421961982164811491114318795721435615291362213311318321186121151
                                  9931241122891924292311432346646113846761512131981437311511562199358147246719196723818191337753291332
                                  1222114361952914555221222296169622784558836751121518966219244215831746229685414172141737963133114493
                                  5218313115227314139655246183769219129243229111742851151185617522413973822128342227812919165581163524
                                  9291132423113289278354324575153169229992171127124135461837121234526253159331631693469211222922141974
                                  8452363325897641925169932431428139199613218111915136812112119111995795222511113131372723121212711118
                                  2197227213274819481124191141229711865192112947469114147211523239645218213151193132942921122111792371
                                  9275351123144952331922211614314212365538513531132558123126944517881183166133275219943389521111173193
                                  1676123311913129662665831191951759436541912564748652528469419649571161712679147469912553225741913996
                                  3191353128953131423711131716711282864474834951441111829112836519349724223297611712534725619191814221
                                  4173761111187311916392959649155953281454675178259425336991997957211941375122951384157137917823346849
                                  6231866821187632943121892433531142499383519821114756411214331534451221651412644522124791217848229112
                                  4218513612717224329629361592483513734819131413112231512426831431594336223618413472242122315818213821
                                  1672513521112672575721281934545322131861691451188212512246411624946313848511278356324319145934746199
                                  7277435215413485681311177121429997231927125112162783124381311646223581365917794813269411132811948118
                                  1171256993195581123322244392112531112921826117456633951228891118213977135113912128736772927396511155
                                  7513423614827252911431224428129419471913857316347921811289615226221512981231328492565212872149824422
                                  4172392667172923414112281271468455913321542234539111143311488844993986926526232111912899467919673129
                                  2266423275271832192191927133161851111718244711617612592821169634215492721212529519332171925375214519
                                  2961251383676393331912784833198316856114611437958511134729539811313332428111416135419161136827381511
                                  2191313432414523594719493126599684313513119243281212311968932355513797175111911888954498999447129422
                                  4116222439791495331225415853138639142821696183279788473226912132161296116634441352242287514831641639
                                  2456122986411166492928291613291461786611191281413582887271831192125366139197116411714187313721143319
                                  3137321286181773323297599141911589613214333724715721771326962716833251289731121417114311929432923141
                                  4471591643429412532212412921891262226734323514259112982727616315933911299142522382749595219893774213
                                  8361434437271446111531163739832741723991191369215895121472249713859411711382822931149329516384858813
                                  7162151376995138977914242232912263921431263824116411237115179847816871745736216484215173821453691814
                                  1221412352976445211311141195476196991326389881615412212286967548955857131279126264116711124668334891
                                  6982434645865366398413542122219772368658463742631121963313814929811193197282524243293233246445611618""";
    private static String[] splinput = input.split("\n");
    private static boolean enablePartTwo = false;
    @Override
    public void run(){
        System.out.println("Part one");
        ArrayList<Node> path = path(new int[]{0,0}, new int[]{splinput[0].length()-1, splinput.length-1});
        int risk = 0;
        for(int i = 0; i<path.size(); i++){
            Node n = path.get(i);
            risk+=n.risk;
        }
//        for(int y = 0; y<splinput.length; y++){
//            String row = splinput[y];
//            for(int x = 0; x<row.length(); x++){
//                Node n = getNode(x, y);
//                System.out.print(path.contains(n)?"X":n.risk);
//            }
//            System.out.println();
//        }
        System.out.println(risk);
        System.out.println("Part two");
        enablePartTwo = true;
        path = path(new int[]{0,0}, new int[]{(splinput[0].length())*5-1, (splinput.length)*5-1});
        risk = 0;
        for(int i = 0; i<path.size(); i++){
            Node n = path.get(i);
            risk+=n.risk;
        }
//        for(int y = 0; y<splinput.length; y++){
//            String row = splinput[y];
//            for(int x = 0; x<row.length(); x++){
//                Node n = getNode(x, y);
//                System.out.print(path.contains(n)?"X":n.risk);
//            }
//            System.out.println();
//        }
        System.out.println(risk);
    }
    private static synchronized ArrayList<Node> path(int[] start, int[] finish){
        allNodes.clear();
        ArrayList<Node> open = new ArrayList<>();
        HashSet<Node> closed = new HashSet<>();
        open.add(getNode(start[0], start[1]));
        while(!open.isEmpty()){
//            System.err.println(open.size()+"/"+splinput.length*splinput.length*(enablePartTwo?25:1)+"|"+open.size()+"|"+closed.size()+" | "+((open.size()+closed.size())/(splinput.length*splinput.length*(enablePartTwo?25d:1d)))*100+"%"+" | "+(closed.size()/(splinput.length*splinput.length*(enablePartTwo?25d:1d)))*100+"%");
            Node current = null;
            for(Node n : open){
                if(current==null||n.getFCost()<current.getFCost()||n.getFCost()==current.getFCost()&&n.hCost<current.hCost)current = n;
            }
            open.remove(current);
            closed.add(current);
            if(current.x==finish[0]&&current.y==finish[1]){
                Stack<Node> path = new Stack<>();
                Node retraceCurrent = getNode(finish[0], finish[1]);
                while(retraceCurrent!=getNode(start[0], start[1])){
                    path.push(retraceCurrent);
                    retraceCurrent = retraceCurrent.parent;
                }
                ArrayList<Node> foundPath = new ArrayList<>();
                while(!path.isEmpty()){
                    foundPath.add(path.pop());
                }
                return foundPath;
            }
            for(Node neighbour : current.getNeighbours()){
                if(neighbour==null||closed.contains(neighbour)){
                    continue;
                }
                int newMovementCostToNeighbor = current.gCost + neighbour.risk;
                if(newMovementCostToNeighbor<neighbour.gCost||!open.contains(neighbour)){
                    neighbour.gCost = newMovementCostToNeighbor;
                    neighbour.hCost = dist(neighbour, getNode(finish[0], finish[1]));
                    neighbour.parent = current;
                    if(!open.contains(neighbour)){
                        open.add(neighbour);
                    }
                }
            }
        }
        return null;
    }
    private static int dist(Node a, Node b){
        int dx = Math.abs(a.x-b.x);
        int dy = Math.abs(a.y-b.y);
        return dx+dy;
    }
    private static HashMap<Integer, HashMap<Integer, Node>> allNodes = new HashMap<>();
    private static class Node{
        private final int x;
        private final int y;
        private int gCost;
        private int hCost;
        private Node parent;
        private int risk;
        private Node(int x, int y){
            this.x = x;
            this.y = y;
            int extraRisk = 0;
            if(enablePartTwo){
                while(y>=splinput.length){
                    extraRisk++;
                    y-=splinput.length;
                }
                while(x>=splinput[y].length()){
                    extraRisk++;
                    x-=splinput[y].length();
                }
            }
            risk = Integer.parseInt(splinput[y].charAt(x)+"")+extraRisk;
            while(risk>9)risk-=9;
            addNode(this.x, this.y, this);
        }
        private Node[] getNeighbours(){
            return new Node[]{
                getNode(x,y-1),
                getNode(x-1,y),getNode(x+1,y),
                getNode(x,y+1)
            };
        }
        private int getFCost(){
            return gCost+hCost;
        }
        private void addNode(int x, int y, Node node){
            HashMap<Integer, Node> xMap = allNodes.get(x);
            if(xMap==null){
                xMap = new HashMap<>();
                allNodes.put(x, xMap);
            }
            xMap.put(y, node);
        }
        @Override
        public boolean equals(Object obj){
            if(obj instanceof Node n){
                return n.x==x&&n.y==y;
            }
            return false;
        }
    }
    private static Node getNode(int x, int y){
        var xMap = allNodes.get(x);
        if(xMap!=null){
            var n = xMap.get(y);
            if(n!=null)return n;
        }
        if(enablePartTwo){
            if(x<0||x>=splinput[0].length()*5||y<0||y>=splinput.length*5)return null;
        }else{
            if(x<0||x>=splinput[0].length()||y<0||y>=splinput.length)return null;
        }
        return new Node(x,y);
    }
}