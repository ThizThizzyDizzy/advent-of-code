package aoc2021;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Day8 implements Day{
    @Override
    public void run(){
        String input = "gfbd geadcb gaefc agdcf cdgfba dcf abdefc cadbg agfecbd df | acgbd dafcg fd df\n" +
"fdcbge dgfeca eagcd cdb bfcag acdebg dcagb ebgdfca abde db | bd dcb agdcb fbegdc\n" +
"gdabcf gcfdae dagecb acfdgbe fabge fcbd cb adfgc acfgb bca | dagbcef fedgac fcadegb bca\n" +
"febag gefbc acfegbd fdega ba adbe fecdga ebagfd gcbfad gba | ebda gabfced baed bfgec\n" +
"afebg bgaedfc degfa bga fdgbea deafcg ab gcbfe dgcbae bfad | dfgae ba faged agefcdb\n" +
"dfgebc cfdgbea adc ad fdcba acgbf fdae degcba efcabd decbf | feda ad decbga cdgefb\n" +
"afce aegdbfc bdgeca def ef ecafgd gedca cdegf cbfgd afegbd | dcaegbf ef acfebgd bedgfa\n" +
"fcgeb gabefdc cgda fdc gdfbae deacfb fcaegd fedga dc gecdf | fdc cdafbe dc cd\n" +
"be acgfdbe bceaf facedg dafebg acfegb cegaf bfe bceg fbdac | fbe abfcdeg cadbf ebacf\n" +
"egbfd da bdca edgab gcbea dga eabcgf dcgbea afgcde dfabegc | ad ceafdg da gad\n" +
"cfdabge bfdac dacfeb gcedbf fbdgac gbd gd acdg dgafb bgafe | dbg dbg fdacb cbdaf\n" +
"fbdeacg faegcd cdfgba geafc bga afebg ab acfbeg baec ebfgd | ba agb baec ab\n" +
"gafd bcaef fg gaefb gcadbe agdbe egdbfc gebfad bfg gfdecba | fdaebg abdcfeg fgb faebcgd\n" +
"efgdc caefg fga gecba cadgbe facgbd aebf fcaegdb fa agcbfe | af gbdfac bgdecaf af\n" +
"gdfe afdec fd edfacgb agcbef cefga adcbgf fda acdeb edcfag | bcdfga agcfed cfdgba fdecag\n" +
"cfgbdea dcaebf cdg ebdfgc gd ecdfga bcefd agfbc gbde fgdbc | cefdb cfagde gd dfceag\n" +
"ecfad cdafg ced febad ebgacdf dfebcg badfeg ec abce beacfd | gefbdc bgfaecd abgcdfe degacfb\n" +
"deg agcd dg cfead febgc cbfgaed ebfacd faegdc gfdce fdgbea | dg gde fbcge aecdgf\n" +
"aed ae gdcae efbadc fcebgd gdcbfea cgbeda abeg dgacf cgbed | ae ae agbe gcbed\n" +
"ebaf cbged ae bgadf efagdb edgab ade bgdfaec dgbfac gefadc | dbgce adbegcf abfgcd ae\n" +
"bgfca dfgcbe bgdeca gfdbea efdgbca fd cfbdg fced fdb egbcd | ebgcda dbf gcbaf dcgfb\n" +
"fgeacb dae dcegab debfac gabdf fecd ebadf fgbeacd de baecf | cbgaedf faecdgb cgdafeb ade\n" +
"gafdcbe fce defagc caeg adbegf cfbgd gfdec fedga decabf ec | ec acfbgde acgbdfe befadgc\n" +
"acdgfb cafgd dgcba cb cab gfdcbea bcfg fgcdae bgade fdabec | bc deacgf bac cfgb\n" +
"dafcg dcbega gdbcfe dgfcb bf gfcabe fbed gbf begdcaf gdcbe | bdeagc fb dbfe fbg\n" +
"gaedfc cdfbg efbcd fed acbed dgbcae bfae ef befcdag abcdfe | fgebdca fecdb fed fedbgac\n" +
"df cedf gfcdb badgfe ecbadfg fdb ebdcgf gbdca cbfage febcg | fcebg gbacd fd fd\n" +
"dbfce faebd dgefba cfgbe dcab acbdfge adfceg dc cfd fadbce | bacd cedfagb acdb fdabe\n" +
"fedbcg adcegb dgbec gabfc dafgecb eadbfc bfd fedg gbfdc df | fged fbdcae dcbfg efdg\n" +
"eafcdb acgf ecgfd dfgbe gec bdeacg dfegcab cg dfcaeg eadcf | dbfeg gc fdeac ecg\n" +
"agbcedf cafbeg gdabf fagcd afegc cdeg dfc dc cefadg dfebca | dc cd dfc afbcedg\n" +
"cfadbge ag bdfea cegdbf cefgda afcegb fag afdeg gcdfe gcad | ga dfgcae dagcef agcd\n" +
"cdf abfdc afcgbd fd ecbgafd gfda cbfage adecb gcdbfe gafcb | cafgb aecdfgb dfgbcea gafd\n" +
"bcgeadf bacgde dca da fedgac dfgec cfgdeb fedca gfda cfbea | fegcbd bgdface dca geacbdf\n" +
"bedcg ageb gde dacegb acgfed bcedf agbdc cfgdba ge begdfac | efbdcga dbacge acbgd egba\n" +
"de ced gcabdfe dgacef egdf gaecf cgbeda dbcaf facde gbface | gfed cbedag abefdcg gecbafd\n" +
"gfbc ecbfdga dbcae cafegd cfa cf fbadg bgadef dfbac fcgadb | eagbdf dafcbg cf fgdab\n" +
"bcedaf cgbdfa dgafeb ca bfacged bagdf egdcf agcb gdfca cda | debgfa cad agfedb acd\n" +
"fe eagdcb efcdab bef fcabe agcbf cbefadg gbfced cbdae aefd | fe dacbfge bgfac fe\n" +
"adfgb eagbfc gbdea fbgead abced egfd dcgfeab dfgcba eg eag | gdefabc aebcd ge cdfgabe\n" +
"gbfad abecdg bedafc cfa ecfd dbcaf cafebg ecdab fc cdbfage | acgfbed cedf gabced cf\n" +
"cgfda eafdb dcgaeb bgef egd ge bcaefd adgcfeb defag bafdge | edbcafg ebgf eg afdge\n" +
"fdb fbegcd bgfad abfgdc efadcgb fbac fdecga agedb gfcda bf | afdbcg abged egbad bfca\n" +
"edbagf eg debgf agdecfb gaed gdcfb fadeb gfe deafbc fgabce | afcedbg eg degbcfa fcbdea\n" +
"bce badcg gedcbaf begacf agdcbe egdfb edgcb deca gfcdba ec | gcfebad ec cbadg ec\n" +
"fbagcd ebdcf caebdf bdeacfg aecf fc dabegc cbead fcd edgfb | ebfgadc bgacdfe gdafbc cdbgea\n" +
"bgfac gdac dg cfebdg becgfad bdg bdfcag edfab fadbg ebcfga | cdbfeg dcgbafe bdg badfecg\n" +
"gde bcgda cagefd ge agdebcf dfgbae gebda defbca bfade febg | befg fgeb baedf edgfab\n" +
"gab fedba agfcebd dcafg egafcd bg fdcabg bfdag cedgba cfgb | dfbgca acfbgde adgbf bag\n" +
"af afg cbfa abgec cdgeba bfedcga faegcb gdfcae gebfd bgaef | gfbea egafb fa egcfab\n" +
"dgcfe ca bcdafg adecg dac bgdecf fdceag cfea faecgbd aedbg | ca acd debgafc ca\n" +
"egadcfb ea eac eagcfb bgdcaf cfedg baed becgad eacdg gdbca | abed ace edba aedb\n" +
"aedbgf dfgcbe fcda fadbg agbec agcbdef fc gbfca fgdabc fcg | cf gbcafd gfc gbadcf\n" +
"dfge adcebfg caebdg dg bfgcd bcegf dcg gaebfc adfcb cgedfb | gabced cgd bgfcdea dgbcf\n" +
"baef gcabefd bge dgcabf agdce baged badfge dgbaf eb cdgbfe | abfe ebg fdbgaec aefdcbg\n" +
"eagbcd gbd gbcedaf bacfd afbg fgcbd cafdeb bfcgda gcfde gb | gfdcb bg gdcfe afgb\n" +
"baged bdaec eabcfd cbe efcbgd ce fbadcg cegdafb fdcba aefc | ceb aecdgbf bcdaf bdgea\n" +
"bcaf becfd eac gdaeb caefbd cabde bedcfg fedgac ac dabfegc | ca fbac bcfdage bafc\n" +
"efc ce deacf ecga acdfg gcbadf defab fdbecg eagdcf gbefcda | ce bgafdec cage aceg\n" +
"cgf cebfgd bgced daegcb bgcef abfeg fc egfbacd dcbf dcgefa | agdecbf gcf abcedfg dcgbe\n" +
"cgfde bgdeaf ebcd cfe efgbd ce afgebc cgafd efdcbg edgabfc | dcgef fgcabe fgbdeca abfegc\n" +
"gecad be gadbf fdbgea dgcfba ebcgfa geb febd gcadbfe gedab | fedb fbdga eb eb\n" +
"gebafcd ea aced badfc bafde cdgbfa geacfb egbdf fea fbaecd | aedc gcadbef bgacfe fae\n" +
"cdaeb bgafed bacegd adc daebg efbca dbcg fgadce dc cdgafeb | dca gfdeac gbcd bdeafcg\n" +
"aefgd ce dfcaeb cgdfbae gebcfa gcbdaf fce bdec ceadf acdfb | cfeda ce gbafecd aegfd\n" +
"bedfa fce ecfba ebcfag bedcag fc cagf geabc febdgc adcgefb | cagbef cef gcdebf fec\n" +
"cdegba fe bacdfe bfgdae cdgebfa edbac fed fecb fagcd fedca | def cabdef cfeda bgfaecd\n" +
"edfcb dcbg ecadfb agcdef afegb gfd gd dfgbe ecdfgab cfbgde | bgcd cdeabf dgf fgd\n" +
"daceg fecdag dfbca gb bfcegd bgc afbgdec adbgc geab gcaebd | gdacb agbe cfebdg bg\n" +
"agfbec deagbfc cbgda adbce deag dfacbe fdgcb dcgbea bga ag | adbgcef decabf cgbfd cabed\n" +
"bgdf df bgceda aedbgf abgedfc cgafe adbge gfade bdcfae fde | gbdf geacf baedg cbfead\n" +
"beacdf egfa afecd ga gca gbdec cagfde cdfabg aegcd cdfbgae | bgcde egbcd cdega dcbeg\n" +
"fbc abfedc bagce fb fcgdea cdgabfe bdgacf bdfg cfbga cdfag | acfbg egacb dfacg fcb\n" +
"dgbafe efdgbc gdc deafc bfgcad cg bdefg defgacb ebcg egfcd | bcfgda gfbead cdg dfgebac\n" +
"aceb bdfega bdfgc bdage ec dcfgeab cdagfe bagcde ecg ebdgc | ebac bgaed gec ec\n" +
"cfbega ab dgebca fgacbed bcgedf fgab abcef fcade fcebg acb | fadcebg cab abefc dcfgeba\n" +
"deacbf fgeab ecdbgf bad fdbgcea eagdb cebagd dagc dbgec ad | gbcdae agdeb dcabef gacd\n" +
"gefcda dga aedbc afbegd edgab fgab gedbfc cfebadg gdefb ga | ag afbg becda dag\n" +
"dbfcge baedc ebg efag dgbaef agfbd fagcbde fdagbc ge geadb | eg adefgb bfdgce gdfceab\n" +
"ebcfgda cg cgfe dfgeac fdcabg agedc agfed dgc adcbe bgafde | aebfcdg agdef gefadbc dagefc\n" +
"dagef gedafcb ecafd cgfabe dg efgadb dbga dge efagb cgdfeb | dbfgce fdaec eabcfg dgba\n" +
"acbdf dbfagc dabgc bgedca bcdfeg cf bfc efbgacd gcfa debaf | ecdabgf cbf fcbaged fcbgde\n" +
"bdfega aecbf cadf gecbf cae dfabe ac gdacbe febcgda dbecfa | fgbade ca adbef dcfa\n" +
"cbdaef ebadf gdbefa eafg aefcgdb gab bacged fdgab ga bgdfc | ga cfgadeb dabgce bag\n" +
"gd aedcfg cadfe dgfbec adegf eafbg gdac bfcaedg ecadbf fdg | fdacge gd gefad egadbcf\n" +
"dfaeg bafged fdgec adefgc ebcgf edc bdeacg cd cfdgeba afdc | bcgdefa caegbd cd adegf\n" +
"cfd cadbf gcadbf cbgd defgba dcegaf egbfacd dc badfg fbace | afcgde afbgdce adbfc dc\n" +
"fgbed fcaeg fbgcda cb cbg efabgd bdfceg debc cabedgf egfcb | gbdcfe edcb aefcbgd edcfgab\n" +
"efgabdc fcdba gbcaf fgdbae ag dgac ebfcg edbacf agb dgcabf | bag ag ga cdga\n" +
"dcbfa bfcaegd fda fabg acdbe gcfedb faecgd gfbadc fa bcfgd | dbcgfa dfa afd fdbca\n" +
"aec bgdaec gbdca efdgbac ecgad ecfdg eabfcd cbgadf ea bega | ace ae efbadc eagbcdf\n" +
"fgca dgfeb bacedf beadfcg adf cbgad gabfd gdfcba af agdcbe | daf facg facg fcga\n" +
"becgfda fgae geafdc dagcfb aecdf ecf fe befgcd ebcad cadgf | gfea geaf fgbdcae adbgcf\n" +
"dcebag agdce cafbedg eda adebfc cfedg dgcab cdagbf ea abeg | ead gdcbae ea dae\n" +
"gaebfd abgefcd fgeadc bgedca cbdgf ceaf gdcef efd ef dgace | geadbcf edf aecf afec\n" +
"afd beadfc facgeb da dgcfba dabefgc ebfdg gdabf dcag fbgca | ad cdga afd efdgb\n" +
"abdge agfcebd feabcg dgbef bgacdf bdcfeg fe bfdgc bfe cefd | fcde efb gbdcf ef\n" +
"gdbcf cafbd ad gbad aebcf cbfegd gdcafeb fegdca adc bgdfac | efbdgac abdg gafedbc acd\n" +
"gdea fdaecb cda fgdec gcbfa eacgfd gcefdb da gaebcfd adcgf | da ad aebcdf ebadfcg\n" +
"faebdcg bagfc debcag acgef fgbace abc dfacge bgdfa bc cbef | cgefa cab bcef cb\n" +
"fgaceb ea afe gcaefd dfbecg bage dbfca fbeac gebcf daecfgb | aef efa cgebfad efcbgad\n" +
"cfgde aegcbf fce fabdcg edfb cgebdfa dcgfeb ef gdeca fdcbg | fe ef ef ecagbfd\n" +
"agebcd fecgabd facg dcbfe agefb cebgfa aec badefg ac cbaef | ac cgaf ac begfa\n" +
"cfebag bea aedcf eb ecfbad adfgec cgbad dfeb dfbaceg adceb | dbef eb efdcgab eb\n" +
"gdfcba efadcg fdcga bdfae cgbd gb afbgd gebdcaf agfbec bfg | fgb bcgeaf bg gfb\n" +
"eafbd ceafbg dgb caebfgd cgbfe fgcd acbedg ebdfgc dg ebfgd | fcdg cfgd gbd dbg\n" +
"gbfce fag aedg ag gafec bcgfda efdca gfdaceb fdegac cedfba | bgdafce cbdefga aefcg fagec\n" +
"cedfa fgcbe acfedb ag cegfa dacfge dgaebc acg afbecgd gafd | gadf cga gdfeca degcab\n" +
"cegfb gf dgefbc cbfade dfcg fbg cedbf bfgdae fcdgabe aecgb | gbf bfg efdbc efgabd\n" +
"acdeg fdbae gcebdfa efgcba cdgb ebg gdabe acgebd gb fcdgea | bg geb beg afgdce\n" +
"bd cbgedf ceafgb agecb bdac daefg befcdag ebd cdaegb dbage | aebcgf bde bed gceab\n" +
"ad adbg beafc dbcgf gfebacd fbdac dgacfb gecdfb adf cedafg | gdab beacgdf daf da\n" +
"adcbge febadg dbgcf bace eb edcga ebg gfcdabe egafcd gbdce | gbe defacg cdfbg geb\n" +
"dfgea fgceb ac egcadf aegfc deac cag bfeagd bfdgca ebafgcd | dgbaef gcfae bdefag gcafe\n" +
"fagce dga feadg fgcdbe acdbegf bafd da gbfed bgcdae bfagde | da dga dag fdab\n" +
"dafbe fdcabe cafbd cfde dc cabgf edagcb acd bcgfade gbeafd | adc dfaecgb bgcaf cad\n" +
"acdgf adgcfe bg fgb gbdcaf fbagc dgbeaf gcbd faedbcg efbca | bg gb cdgb abdgcef\n" +
"adbecf gcfdeba acdge dfab befdc bagfce af dcfae fca bedfgc | acf fa cfa cfa\n" +
"eabgcf agc cafgdb adgbf dcfa edcgb ac bdegaf abgcd gedfcab | ca fcegab bgcdfa acebdgf\n" +
"gcbfde bg gdba bafeg bafde cfaeg cfbead gbe fgebad abecgfd | beg fdgaebc bge cebgfd\n" +
"ad fadcb fbdce acd faed dbfegc cbdafe ecbdafg decbga cbafg | da gadecb bcfdae cad\n" +
"dcfgea defbg becgdaf eadb edafgb be gafde feb fdbcg gfebca | eb afdegbc bef eb\n" +
"egcdb ae fbdeac bgace fabgc edgbcf eac bacfegd eadcgb geda | fcdeba gdea ace ea\n" +
"befd dcgeaf cbdage bgfceda fbcag be daegf agbfe febadg bea | eb edafgbc acbged ebfga\n" +
"dbfgcea abfecg bga dgca ecabd ebcfda gdbef ag bedga gadbec | agcd befdg bga cfedba\n" +
"da agfde fbega fda bgdeafc cgad cdfgbe efgcad afedbc decgf | cdgbfea dagc ad daf\n" +
"bfcadg aecgfb fgade cbafg fdcgaeb db bdg agfbd adbc bfdgce | dfage bd bacd gafbd\n" +
"bcdfge eadfg fcda dfegcab fdbgea cfg egfca fdgace baegc fc | fcebadg edafcgb fgc fc\n" +
"fbdac gadbfc fedbca bfage feabd ed eda aebgdc feadcbg ecfd | ed efdc dcef fecadbg\n" +
"abdge abgdce fg efdga dgeafb dgfb fge ceafd bdefgca fagebc | aebdg feg dbfg cedaf\n" +
"dgcf caefb fceadgb fd cdbfe fgbced begdfa cdgbe agbedc dbf | dbf bface edcbag dbacgef\n" +
"bgafe bf gbfcad gadef egfdba baegdfc bedf fgb becag defcga | dfbe dfagec cegdfab bf\n" +
"ed cgfaebd edbgca dgabe dcbagf dbgcef agfbe dacgb egd aced | dge egd degab abcgfd\n" +
"bfgeca edcbg deabgf afdge adebcgf fb fgbde fgb adfb fcaged | bafd afcgbe gbf bf\n" +
"bg afcdb gedfc afecbg cdbeagf dgeb cegafd gbfdc gfb cfedbg | gb gb gfdcea cfbgd\n" +
"gf fbgc gbcea gef abgecd efcag fdcea gfcaeb gebfdac fgbeda | gebcda degfbca gef cfgea\n" +
"fadebcg dfecag dcbaf cgdfb bg cfgbde fcged bgc gefb dgcbae | acgbde cgb fbge becgadf\n" +
"gdba fbcgea dcaegb abecg eadbcf ad afcedgb agcde fcedg acd | cageb dac adgce adc\n" +
"ebdca fd dcfbe efbcad afdb ecbgda aecdfg fdc cbgef efdcbag | dbaf df cbadgfe bdaf\n" +
"dgcbafe ef gaefcb bfgead ecfag gadec gcabf gfbdca fceb afe | afbcg ef dagec cgeaf\n" +
"abegc badgce gecfdb gb dagec gdab dcgafe dgfabce ceabf geb | gb dcagbe cbaegfd acefdg\n" +
"adec cbgde cdg egbdaf edabgfc adegb cd cegfb gdceab cfbdga | dc cd cd dcae\n" +
"fbadcg abc ba cfbge abed afgecd aecbg adcegb gaecd fgbdeac | acdbgf afdbegc bgafdce acb\n" +
"fa febgc cgfead ebgcdaf abged beafcg begaf aef ecgdfb bafc | fgbea acbf gbfeac afcgdbe\n" +
"bcadg baced gbfcde ec aegc cgedfab dec aedbf dbacgf abcedg | adbcg ce fagdcb adbcfg\n" +
"fdgcba acdg befacd bcg bgdef gbceaf gedafbc dfcba dgcfb gc | facdb gbc bdfeac gdfcbae\n" +
"cd gdce aedcfb fabecgd gdacfe cad adgcf gfbac gbafde deafg | dac cdbgefa cd dfcgeab\n" +
"aebdfg fgcadbe gcafbd eadfb ea abfgd bedagc eba fecbd eafg | cebfd dcbgeaf becgad ae\n" +
"edagfc cagdbef eadbfc ga fagec gdae efbgc cag gdcabf feacd | acg cga cgfdea ga\n" +
"agebdc bagde efg ecfadgb gbfeac fdage fg bfdg geabdf efacd | afgedb cbegfa adbegc fg\n" +
"dgcfb gacbed bgaefcd eb defac bfae bdecaf cbedf fgdeac cbe | eb ecb gbdcf egdcba\n" +
"bg dcegbaf bcafeg aecdgf gbf gfecdb gaeb eacgf fdcba cafbg | bfgdec gbf aebg bg\n" +
"aeg abfdcg gefcdba bgfe bcgaf edafc aecgf ecabgd cbafge ge | age acgbdf eag egabdc\n" +
"bafgde gefbcd caegfdb cdb fbcad gbfad cb dfcae fbacgd cbag | gcab afcdb bc cdbgaf\n" +
"cbgdf fda ad acgd agbdf dfaceb bcdfge agfcbd efgbacd gafbe | dfa dfgbec ad fad\n" +
"gfdca edafgc ge fbedcag ebfgad dbacgf beadc gfce eag gecda | gacde cegf acgbdf cbgadf\n" +
"cdb dfgec dacefb cfdeb cbaefg ecbadg bafd afceb bd abdcefg | ecbadf bcd bd afceb\n" +
"gbed be cdfbga bef ecbdfa gdbaf bdfage bgefa fcgae gefabdc | fbagecd gdfab gbdfa gdbe\n" +
"dafeb gfedb bcegf dg edagbf dagcfe fdg gebdacf dcfbea gdba | gfd bgad gd febgad\n" +
"gbcdaf aedfcbg dcge dcagf gecfda fde fgdbae fabce eadfc de | decg ecdg gdec de\n" +
"bfcga cfeg begdca ebcfag bdacef aecbg fac fc fbgda febcagd | efcg cf abdgec gfabcde\n" +
"cgfb fca dfceag bcfae gcabdfe begaf cf befacg acedb afdegb | egdbfa acf acbed fc\n" +
"bedgfc ab fabe acfgd cgbdea fdacb fdeabcg bac fbcde edacfb | bfae efcadb dfgca cba\n" +
"bcgeadf cfadg fge bdacfg eacfg bcedfg ef edfa cbgea cdefga | ef ebafgdc efcgbad adef\n" +
"dfgec fcdgaeb befc fb afdegc bgcdf dgbaef gbf cgbad cebgfd | bfg fb cbfedag ebacdgf\n" +
"ceabfdg dfe dfcg gedaf afgce ebdga egcbfa edafbc df gdaefc | abcedf ecfagbd gaecfbd gcfd\n" +
"degfb fa fdeab acfb deacbf gdcbea fad bacde efacdg bfdcega | adf dbace gfedcba gcebda\n" +
"badegfc fcebg fd fbd fdeg afcdeb gfeabc fgcedb bdagc cdbgf | dbf dbf fdb fedg\n" +
"eabcfg cefbdag cgebfd cafge deac gde adbgf decgfa de edafg | fdage adce de de\n" +
"acbdeg cdfgba gac dbega adfbge cdeg acbgdef gaebc cg afebc | dcgfba acg ebagfd bdecagf\n" +
"bfadcg bgcda ega gdcef gdbecaf ea edba egadc gebcfa gadbec | ae bade gdcaebf eadb\n" +
"fe efcagbd cfgbd efdb gef gfced decga gbcedf gdfbca aebfgc | ceadfgb dgbacf cgbdefa egf\n" +
"gd fbcgda gad gbdfa dfcg ceadbf acgbdef ecgbad faegb bdfac | gfcdeba dg abfcd fbgae\n" +
"becgad egc ce edfgabc caef bgfdea cebgf faebgc fdgcb gbafe | ceg febag abgfe ec\n" +
"abdef acdfbe gbdcea egbcf abefg gedacfb ga adgf gae aebdfg | gfad ga agdf gea\n" +
"befdcg adcf fcdegab debcf aegfb dae cadbef da bfdae bdecag | gbfeacd gdbefc ad ad\n" +
"dabgcf fgbdeca gecfbd fcdge gfbe bdgfc dcefa eg bagdec egd | edg dge dge dge\n" +
"afd dagbc ceagdf fa cadbgf fbga badgec fdeacgb fcebd dfcab | bcdgea fad fbecgda af\n" +
"dfecga cagbde fcdaeb dfgc afegc cf fec bgaef edacg fcegdba | aebgf gceadbf ebgdac cbfeda\n" +
"gceaf gcbe bfecga beagfd cabgfed gfcba fcadb fgb gdcaef bg | abcfd egcb begc cegabf\n" +
"gcf adfebcg dcbeg fdgacb gfceab fg gafe acbef bcadef cgefb | bcegdfa cebdg fgc fgc\n" +
"dgbafec caf af gfcea cbgea efcgd aefbcd gecfba bgfa aegcdb | caf cegdf af agbced\n" +
"cgfd gd fedbc dbfaec fedbg adbgce bgefcd bgfae gbedafc gbd | ecabdfg cdgf gdcf bdacge\n" +
"bgc bcdfa becgaf gc dbegf fdcabe dgbfc cagfbd cadg fdabgec | fdcgb cdag gc cdfba\n" +
"fbgcda gdce bcg acdefb aebcfdg fegba cg cbefd bcfge fgbecd | becgf cgb bgc bgc\n" +
"afebg dceab aefbdg edgba agcdbf gd adg edfcgab fged fbgeac | cbagfd cgadebf agecfb deacb\n" +
"bagcdf bcafde gabe fdabe dbegaf ag dgeaf agd facdbge fedgc | dbface gad baeg agbe\n" +
"df gabfc afgcbed edgf gcbdea bdf ebdfcg fbcdae cgdbf bgecd | ebgacd dgfe adbfgec gdbfc\n" +
"gadcb cgfd fadbce gbd bfcda fcbagde cabeg cdagbf dg faebgd | gadcbef dfgc fgdc dbg\n" +
"dcagb cdfeba feacd fgdeac cge ge dgfe bafcge agced gceabfd | deafcb fedg gdef gacbd\n" +
"dc befgda dcgf gceba edc cbdge daecbf daefbcg ebgfd ebcgfd | edc baefcgd ceafbd dce\n" +
"cfdab edag afdcebg gba ecdgb ag fecgba bgdca egdbcf aebdgc | bagdc bafdcge gcdafbe aedg\n" +
"dgfecb bdfage abe defbc ae fabgecd efac fdbcea gbcad dcaeb | abe cefa gfedcb adecgfb\n" +
"dcegba fd adfgce caefb adgfeb fagdecb gfdc dfeca gdeca fed | fd dfe efacd gdcbea\n" +
"dafbec gbefd gcdfba edagcbf fegcba abfed efa fdcba dcea ae | fea afe fdaeb adce\n" +
"af bacf gcaebd dfgeb ecfdga bdaef aebdc decabf afe cegabdf | af bafc fea af\n" +
"cdefbg ce acef gce cbgad afdbge fedacg dceag efagd bgadcef | ec cfea dcgfbe feac\n" +
"gfbcd afbgd fgbaed abg ba geadf gdcbaef dbceag afbe feagdc | ab bdacfeg ab bga\n" +
"cfgea defcga feacbg cfabe gcbafd fbc gfbe baedfcg deabc fb | agcdfe bfge fdgabc ecgbfa\n" +
"gbdcea gbdf fgecb fbcdage agefc bge fedbca efgbcd bg debcf | dcgfeb cgaef bcdfe gabfdec";
        System.out.println("Part one");
        int count = 0;
        for(String s : input.split("\n")){
            String[] strs = s.split(" \\| ");
            String[] in = strs[0].split(" ");
            String[] out = strs[1].split(" ");
            for(String str : out){
                if(str.length()==2||str.length()==4||str.length()==3||str.length()==7)count++;
            }
        }
        System.out.println(count);
        System.out.println("Part two");
        count = 0;
        for(String s : input.split("\n")){
            Display d = new Display(s);
            count+=d.decode();
//            d.print();
        }
        System.out.println(count);
    }
    private static class Display{
        private String[] in, out;
        private ArrayList<Character>[] segments = new ArrayList[7];
        public Display(String string){
            String[] strs = string.split(" \\| ");
            in = strs[0].split(" ");
            out = strs[1].split(" ");
            String[] all = (strs[0]+" "+strs[1]).split(" ");
            for(int i = 0; i<segments.length; i++){
                segments[i] = new ArrayList<>();
                segments[i].add('a');
                segments[i].add('b');
                segments[i].add('c');
                segments[i].add('d');
                segments[i].add('e');
                segments[i].add('f');
                segments[i].add('g');
            }
            for(String s : all){
                if(s.length()==2){//this is a 1
                    for(int i = 0; i<segments.length; i++){
                        var seg = segments[i];
                        if(i==2||i==5){
                            for(Iterator<Character> it = seg.iterator(); it.hasNext();){
                                char c = it.next();
                                if(!s.contains(c+""))it.remove();
                            }
                        }else{
                            seg.remove((Character)s.charAt(0));
                            seg.remove((Character)s.charAt(1));
                        }
                    }
                }
                if(s.length()==4){//this is a 4
                    for(int i = 0; i<segments.length; i++){
                        var seg = segments[i];
                        if(i==1||i==2||i==3||i==5){
                            for(Iterator<Character> it = seg.iterator(); it.hasNext();){
                                char c = it.next();
                                if(!s.contains(c+""))it.remove();
                            }
                        }else{
                            seg.remove((Character)s.charAt(0));
                            seg.remove((Character)s.charAt(1));
                            seg.remove((Character)s.charAt(2));
                            seg.remove((Character)s.charAt(3));
                        }
                    }
                }
                if(s.length()==3){//this is a 7
                    for(int i = 0; i<segments.length; i++){
                        var seg = segments[i];
                        if(i==0||i==2||i==5){
                            for(Iterator<Character> it = seg.iterator(); it.hasNext();){
                                char c = it.next();
                                if(!s.contains(c+""))it.remove();
                            }
                        }else{
                            seg.remove((Character)s.charAt(0));
                            seg.remove((Character)s.charAt(1));
                            seg.remove((Character)s.charAt(2));
                        }
                    }
                }
                if(s.length()==5){//this is a 2, 3, or 5
                    for(int i = 0; i<segments.length; i++){
                        var seg = segments[i];
                        if(i==0||i==3||i==6){
                            for(Iterator<Character> it = seg.iterator(); it.hasNext();){
                                char c = it.next();
                                if(!s.contains(c+""))it.remove();
                            }
                        }
                    }
                }
                if(s.length()==6){//this is a 0, 6, or 9
                    for(int i = 0; i<segments.length; i++){
                        var seg = segments[i];
                        if(i==0||i==1||i==5||i==6){
                            for(Iterator<Character> it = seg.iterator(); it.hasNext();){
                                char c = it.next();
                                if(!s.contains(c+""))it.remove();
                            }
                        }
                    }
                }
            }
            for(int i = 0; i<segments.length; i++){//cleanup
                var segment = segments[i];
                if(segment.size()==1){
                    for(var seg : segments){
                        if(seg==segment)continue;
                        if(seg.contains(segment.get(0)))seg.remove(segment.get(0));
                    }
                }
            }
        }
        public int decode(){
            String val = "";
            for(String s : out){
                switch(s.length()){
                    case 2:
                        val+="1";
                        break;
                    case 3:
                        val+="7";
                        break;
                    case 4:
                        val+="4";
                        break;
                    case 5:
                        boolean top = s.contains(segments[1].get(0)+"");
                        boolean bottom = s.contains(segments[4].get(0)+"");
                        if(!top&&!bottom)val+="3";
                        else if(top)val+="5";
                        else val+="2";
                        break;
                    case 6:
                        if(!s.contains(segments[2].get(0)+""))val+="6";
                        if(!s.contains(segments[3].get(0)+""))val+="0";
                        if(!s.contains(segments[4].get(0)+""))val+="9";
                        break;
                    case 7:
                        val+="8";
                        break;
                }
            }
            return Integer.parseInt(val);
        }
        public void print(){
            System.out.println(Arrays.toString(segments));
        }
    }
}