package problems;

import java.util.*;

public class Gemstones {

	/**
	 * Online solution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int t = scanner.nextInt();
		Set<Character> set = convertToSet(scanner.next());
		for (int i = 1; i < t; i++) {
			set.retainAll(convertToSet(scanner.next()));
		}
		System.out.print(set.size());
	}

	public static Set<Character> convertToSet(String s) {
		Set<Character> set = new HashSet<Character>(26);
		for (char c : s.toCharArray())
			set.add(Character.valueOf(c));
		return set;
	}

	/**
	 * My Solution
	 * 
	 * @param arr
	 * @return
	 */
	static int gemstones(ArrayList<String> arr) {
		arr.sort(Comparator.comparingInt(String::length));
		int count = 0;
		boolean isGema = true;
		String verify = arr.get(0);
		ArrayList<String> aux = new ArrayList<String>();

		for (int i = 0; i < verify.length(); i++) {
			isGema = true;
			char ch = verify.charAt(i);
			if (aux.contains(ch + "")) {
				continue;
			}
			for (int j = 1; j < arr.size(); j++) {
				if (arr.get(j).indexOf(ch) == -1) {
					isGema = false;
					break;
				}
			}
			if (isGema) {
				aux.add(ch + "");
				count++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);
	/*
	 * public static void main(String[] args) { System.out.println("Begin");
	 * ArrayList<String> arr = new ArrayList<String>(); arr.add("wlqdbbmrbbca");
	 * arr.add("fndlpcyisdcosxjrglsyracbbqaebwdmbkdofeexoqphwfgacdlnxkmprxrljpdy");
	 * arr.add(
	 * "dzxxhqjophycwuccrwrhbekczqrqiifjbcqkxszhtqvabfncsalkvffcbaxsapnpmohk");
	 * arr.add("tootcndrwusguhbdbxkluagaxeobzyeddacdwngrwmbchqplu");
	 * arr.add("jihcqygidhsfoyvabxajuvlphluzomo");
	 * arr.add("zcvocajjpaxauohhdfcblwwizdnpygqlwrblbppnqmooadxtedgkudru"); arr.add(
	 * "tsoicexkzfinpcbnsdovrtkelctbeitbgldqqpfxuxtfpybzusdjpjzgisbybevhhfpkrqeddbsqchae"
	 * ); arr.add("eznasnpflcumubjwdalxzwutdfrwpyhkncvbpsvbnylugixnpgvk");
	 * arr.add("cabhhevseayd"); arr.add(
	 * "khrsufraowtxgonxgdrffrpvdbdeeqagpurkkseywfaqypnjidjsrumgoviprjcbcxuicbzixvlbtdqnfb"
	 * ); arr.add(
	 * "pwkxxwbwtjaknqbfsxkowtozovcjguvynwnbvwewcgosuicbfnemhluxjvgmpddchjonjm");
	 * arr.add(
	 * "tpevrcojclbgydcikeaaqmvmyrbtiivlubdgbgvwsfqhihemnykkmsebvtxulxdbkhqrdogvtcenhviqrr"
	 * ); arr.add(
	 * "azngfwglcvbmfrhrawhpysdqjmuggivpguxqacmjnhxxzuftnjendthrdwwexvtbpkrttomssdcebzmaxxre"
	 * ); arr.add("gazwzratddbac"); arr.add("pjakhbucnzdldhchel");
	 * arr.add("bzcdesupznpmaebdomtgqxkfxomqmva"); arr.add("drbcqbaoaing"); arr.add(
	 * "oallngsofuoqopfthnngehfosscymerssookvbjjgxeqccatdmnvwalwibauyhtswkjsppsmwdmiquqqd"
	 * ); arr.add("fwjhsqtwoliyvbdsdbefdaesvknactlpz"); arr.add(
	 * "lsqxzjkytgmdfiwbqlaswmxbhqibqqyfveczxcqcvjenctpcdsysdrkispsarxonifoggd");
	 * arr.add(
	 * "cgjhbyibpghbnqraaqimsefnkxvvnnnvrbotbneigymolqghyxaprmmxfcwmqxxakydoorjicvxijutcbmyrqqzxisdqqeqaaa"
	 * ); arr.add("tseejabzccxmphwvecvqsorfdhpvkuuqxgeqtbvdajdubblmvfjmubpktvflu");
	 * arr.add(
	 * "ododeqifxgsxrhtbualcbjgjubimbizxuopccbobkqskvtovpujnwjsaxbnqcmiqrntaudkfwspjmmpcekwu"
	 * ); arr.add(
	 * "yhlhuoscxdyslxinfyyrwjaexefyqtzzotxydhxrjaojnqzaznjqqldydmsybeggadvuvphdygluedsljedk"
	 * ); arr.add("qtmjsdceqdtdlpoyctszkifabagypkonttbxosbquoopru");
	 * arr.add("kduacfioftizbryvrikrysxmojkiukqtyiocj");
	 * arr.add("dhjaaxsagfabdffuvfwffiaelhwuxdvciqubmpfewuchvrbyukkjathabpiaqf");
	 * arr.add("gioaqqhlzwgpaznqdbqnqwkodrlmdmivfqkoanscdhawmwk");
	 * arr.add("wmraodcomumbhrwble");
	 * arr.add("bkiqpcetolvpckpemxhymmfcdcsjbiixidcdindtakxajzhql");
	 * arr.add("bbcajgcctdxdw"); arr.add("yrxoabvaosvalwggofhdnonsvqztnapicpypf");
	 * arr.add("tlneqntaagjkcdlhvomdwiirbgsmhxdjvtduhbntnmqqbqqtulwgxnyzyiatasmydn")
	 * ; arr.add("mkfbvhtdugdzcztgvedbebgdfnzzpxefcycvevvucibhccazvdoaxuzfertfbrn");
	 * arr.add("dcymhktqxamjotsexnidodqdeqbpygzbhwvermncjcopcgayqrw");
	 * arr.add("nzfcbhfstkvldbapdnpimqc"); arr.add(
	 * "ofaavkxwjacogcrdfwcmopswvpmjaphsuzhglkyqdobeouagunexnbtwpyccggjiixmwacjtzcbcxgeqbbiftqimcqci"
	 * ); arr.add("svavfhwzvcgemhibkmhhamvczdwtnvzcqddxmkugvpqy");
	 * arr.add("trxbzxqazollbxmfketdzvloclw"); arr.add(
	 * "jzbyxloucwcwdgcjsawafpyebrsfcxygpwczmtbkxejzfdtzhujjqvmizjskhuvdwparvjkazbhpandhsrjbbb"
	 * );
	 * arr.add("vnaccyqjdbybjatosxejkjncohtniwjjdjqktackfroiactzbfrtmewywphcdiwq");
	 * arr.add("bpnvaxvcivtihhhefd");
	 * arr.add("zccbjehjumbdyczsafzlluqgtxmbzvvitranqgiknxmoszhqorkskutftqqysh");
	 * arr.add(
	 * "rxxmozqhwuhbicfhpvczcsgknddrbfspbequqnhzfjmdacbaihdyrohyovwnotjiiropztgqfxis"
	 * ); arr.add(
	 * "bzapvmrhixzgzlfdnosohwmbmllmrutgqyddinejxihnmatqhcaczjklgtocnxfkllhstcxsravgebdiccd"
	 * ); arr.add(
	 * "hrcxznkceivmxbdrgbfwthnbpnkcfihrabosjzssfiadojyynshqdvhbvabvffmtwvmgecjdzonqgtnusspxccq"
	 * );
	 * arr.add("pcjxvcxyhqpbqngyhjgeprprgdooiiaipzrorffxaaihqidyshtowxojygtoenaifh")
	 * ; arr.add("nnjbfbgcmuhftagjqpjgqbbcdbdiparirvhkmpylviaf"); arr.add(
	 * "bdtyuydirsmgkfxjwngqkysjjdrutcgbyqsgefsccxdtmkbgatycoieztaktqpzkxysfbn");
	 * arr.add(
	 * "acizgadzqebandvgeldgzrfgpxxzttbktxwkvdyrcwoicanahosxiwthabojcatmhayvcevz");
	 * arr.add(
	 * "xdaiwbqoikhyccdufjjjjitjiwwwywchqfzunqjbadddejbcriznxdhaaxtzsjcaquhpl");
	 * arr.add(
	 * "omucudabkddunbcbubzhcnhbjgapbnebkwbqhgmyduxgonabopsecdcafqrdsayeoredfglcfblayusgeepp"
	 * ); arr.add("ybxrrcwvdqba"); arr.add("ejyyvcrzcimznadxwrasbhagzlnjwtexkabnu");
	 * arr.add("jzcykuxbmamradenpajyvjxfjvipodpqmyi");
	 * arr.add("wyburlppmrnyixewitaqesvdftovwfvopxaiwxdatukjxbimecsqdtcxtilzfqqgomt"
	 * ); arr.add(
	 * "zpkpdebbvnirypwjlchhwpyhpadmblounzusawtiixamaydaqcrvtkbxhoxexbafrzkurgvae");
	 * arr.add("qvrqbcdjnfdgdgvjnccabtgvlxa");
	 * arr.add("lzwzwklnpahxwezchfvurznjylmjgobvmbelapgdyacxpbcmxbofaakihkbcdkwwb");
	 * arr.add("ddlavbrdkklaypc"); arr.add("dekyvdtcmsixuuyujmhactampubvz");
	 * arr.add("cqzcqgarcpoapulcljenodvtvlsfipmfzdvbiqvnxxbvduhub"); arr.add(
	 * "phjozbkkmhlxqimbclzjtqhjixnngicclvtfasorpguwbheuceembwyifssmuvesjgicziypwuzmgyksutpqobxddgwcr"
	 * ); arr.add("lzfedysysuibdzjyxfamicgdtfsgxglqubaqspwsocljjaekcafqvlgtnlkbx");
	 * arr.add(
	 * "kjeklqrbkcjbsjmocfrmnrmpyhyqzpqeolhzaxdhfhszyldktadpkreubveuavrmolcctupzeiibha"
	 * );
	 * arr.add("uidbqczzqfwspncrqjhpngaouinykucunkaprswfxzkaljkslrwqizqykstkxaacyzc"
	 * ); arr.add(
	 * "ywjwbbwamomnnwctecvodirukyibufghijcgiegktxapfoaatqbjywhqajrsvcwbyuhntrlkd");
	 * arr.add(
	 * "lpxdftislbfrtxbuoyfyeelxcxforisknoxwyotrxkbcaxmaytbohrodsckhssomuhdhtsqdea")
	 * ; arr.add("aippypcqtvscomvdafcb"); arr.add("wcbrwatddd"); arr.add(
	 * "hpdcdcqcjbyggbubomogsesiauxopdcmmcvqutimxcbraymsnchezdzmuctorcuswynpdh");
	 * arr.add("qcafeedflhyawnahuszb"); arr.add(
	 * "kdimimomokymjhxjvudagjalxytjzcylcbxoybqywhlvjkxkgyfpqrfwwgqbgdcnhmcxxkhmckhvcekpcwaggktrspryaucfiy"
	 * ); arr.add("tbaqqdmhdknqxwyyvatrycayfjkjb"); arr.add("ichmdasijhpbpbuo");
	 * arr.add(
	 * "ikgcjftofkfmgehpxpmbvwvurejebajgdtqwoerurztiqdusibgtallagziophyecgburqztocdphhjkzfg"
	 * ); arr.add("opqdatbovwtigueygizeqaudfpisgsbddlzuxkbvpizadirgcghja"); arr.add(
	 * "oeuwvlgdivdmtedvouiwhromvcvawbfreqkypvngbztnjljwubshudqbxqzxcwvvdymupuuydwaabsufzccjmatnp"
	 * ); arr.add("ibksgubbbtyeddewdurzlpczocvgwlomarjahlktxyfwunft");
	 * arr.add("scjmatbgasqrkskdcoc"); arr.add(
	 * "pbptqjdigqxrgfeeifudazmjagpqfpkigehycevigskeqfeophcadwahpasejooytjnnzgrebmkwyjhomhokbghsurbnbcix"
	 * ); arr.add("nvqtgvbdjvnkhchxbtsqcygnnatyaxtkyolmzvrxjrmcfworpeazmifcmjbom");
	 * arr.add("zeactmjqxcftxxpxbzsatetbqxabwsbrsdfzgk"); arr.add(
	 * "jzokqdgtmiknlupiaitmdxyzjgteurrpwqmzjnmpyvhrlkvrvohywsjzbobdunkfhpszyfzhvbmtahwyeyssmxilwliadcbcohf"
	 * ); arr.add(
	 * "qbmdzqlvhwvpwuepcsalqlstsysgqbzrjwqztadfxhtcrudmtdgyjkhwwiwlxabbevplbprkcy")
	 * ; arr.add(
	 * "obwpxlkplacnwnsbqbifgbjtpdjdvsymtmgapjyxmzgrlnhjlafqczfsgdpadipycrziahuhh");
	 * arr.add("pcfoigiluxobfgdlhemqcncaawlhvcauucm"); arr.add(
	 * "suhjsgbclvdvzpelducrhpzqkpbhmowkhhxzzealabinwtzqizeyoyyuqdugxtzxgdbf");
	 * arr.add("shyezfcfdqayb"); arr.add(
	 * "uvwjsmnyskxzcsuwwwiaheemzedvwkbfmedsclcflqginqcgawykbaahsgcgkqfhwyqtdacdr");
	 * arr.add("fbselosapztxrocwmvdzgbhpebwebpomerzccgvr");
	 * arr.add("lxnoynimecbmdovnyauapznjtbyapkjwdexqimvdoqfjzgdlswzumrvyveimtbzpze")
	 * ; arr.add(
	 * "fcydvajeeehvhwrbckiixpnnxwpxehmclojcdpyyoukjxmxykahcpnbenewajqoxpahwhmyyqwovpusk"
	 * ); arr.add(
	 * "baastodbtupzsqgefufkgnzsozyfgogynchiwxulvqnadkltpwkrqasmuwmhefdzmtobjexyhgbqzhdlxygmlcubczjgwayjv"
	 * ); arr.add("ubnixmgdixzyvsdscejnnqrngqcynvzkoatgldnwtbqyqzearbpyfls");
	 * arr.add("gmphijuoyzenednrblzjdftchkygcmujasetaqczmobuwlnbdyrpcvvxvqoc");
	 * arr.add("kuujodranurqhexxrgcnjtgdgakqxkqvausdgbqx"); arr.add("dukpfcaibe");
	 * arr.add("rguziolcjrbaicmodpzxhbdmdtpcmfrtgauhnbcggnazeqds");
	 * arr.add("jrkzfbzunysltcdlzpbhawvodtataapvoietwq");
	 * 
	 * int result = gemstones(arr); System.out.println(result); scanner.close(); }
	 */
}
