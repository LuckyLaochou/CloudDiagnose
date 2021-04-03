package cn.laochou.diagnose.prediagnose;

import com.hankcs.hanlp.HanLP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 预诊断模块
 */
public class PreDiagnoseUtil {


//    public static void main(String[] args) {
//        List<String> sample = new ArrayList<String>() {{
//            add("本病起病较急，潜伏期1～3天，主要表现为鼻部症状，如喷嚏、鼻塞、流清水样鼻涕，也可表现为咳嗽、咽干、咽痒、咽痛或灼热感，甚至鼻后滴漏感。2～3天后鼻涕变稠，常伴咽痛、流泪、味觉减退、呼吸不畅、声嘶等。一般无发热及全身症状，或仅有低热、不适、轻度畏寒、头痛。");
//            add("急性咽炎起病较急，初起时咽部干燥、灼热，继有咽痛，空咽时咽痛往往比进食时更加明显，疼痛可放射到耳部。全身症状一般较轻，但因年龄、免疫力以及病毒、细菌毒力之不同而程度不一，严重者表现为发热、头痛、食欲不振和四肢酸痛等。—般病程在l周左右。检查见口咽及鼻咽粘膜呈急性弥漫性充血，腭弓、悬雍垂水肿，咽后壁淋巴滤泡和咽侧索红肿。细菌感染者，咽后壁淋巴滤泡中央可出现黄白色点状渗出物。颌下淋巴结肿大，且有压痛。");
//            add("慢性咽炎患者咽部可有各种不适感，如异物感、灼热感、干燥感、痒感、刺激感和轻微的疼痛等。由于咽后壁常有较粘稠的分泌物刺激，常在晨起时出现较频繁的刺激性咳嗽，严重时可引起作呕，咳嗽时常无分泌物咳出。上述症状因人而异，轻重不一、往往在用嗓过度、受凉或疲劳时加重。全身症状一般均不明显。检查所见：慢性单纯性咽炎可见粘膜弥漫性充血，血管扩张，呈暗红色，咽后壁常有少许粘稠分泌物附着。悬雍垂增粗，呈蚯蚓状下垂，有时与舌根接触。慢性肥厚性咽炎可见粘膜肥厚，弥漫充血。咽后壁有较多颗粒状隆起的淋巴滤泡，可散在分布或融合成块。两侧咽侧索也有充血肥厚。");
//            add("萎缩性咽炎患者自觉咽部干燥，有时可咳出带臭味的痂皮。检查可见咽粘膜干燥，萎缩变薄，色苍白且发亮，咽后壁粘膜上常有粘稠的粘液或有臭味的黄褐色痂皮。");
//        }};
//        String test = "咳嗽，流鼻涕";
//        List<Double> result = new ArrayList<>();
//        sample.forEach(item -> result.add(getSimilarity(item, test)));
//        System.out.println(Arrays.toString(result.toArray()));
//    }


    /**
     * 分词
     * @param sentence
     * @return
     */
    private static List<String> getSplitWords(String sentence) {
        // 标点符号会被单独分为一个Term，去除之
        return HanLP.segment(sentence).stream().map(a -> a.word).filter(s -> !"`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ ".contains(s)).collect(Collectors.toList());
    }


    /**
     * 合并分词结果，列出所有的词
     * @param list1
     * @param list2
     * @return
     */
    private static List<String> mergeList(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result.stream().distinct().collect(Collectors.toList());
    }


    /**
     * 统计词频，得到词频构成的向量
     * @param allWords
     * @param sentWords
     * @return
     */
    private static int[] statistic(List<String> allWords, List<String> sentWords) {
        int[] result = new int[allWords.size()];
        for(int i = 0; i < allWords.size(); i++) {
            // 从 sentword里面找到当前allwords的每个元素的个数
            result[i] = Collections.frequency(sentWords, allWords.get(i));
        }
        return result;
    }


    public static int getSimilarity(String sentence1, String sentence2) {
        List<String> sentWord1 = getSplitWords(sentence1);
//        System.out.println(Arrays.toString(sentWord1.toArray()));
        List<String> sentWord2 = getSplitWords(sentence2);
//        System.out.println(Arrays.toString(sentWord2.toArray()));
        List<String> allWords = mergeList(sentWord1, sentWord2);
        int[] statistic1 = statistic(allWords, sentWord1);
        int[] statistic2 = statistic(allWords, sentWord2);
        double dividend = 0;
        double divisor1 = 0;
        double divisor2 = 0;
        for(int i = 0; i <statistic1.length; i++) {
            dividend += statistic1[i] * statistic2[i];
            divisor1 += Math.pow(statistic1[i], 2);
            divisor2 += Math.pow(statistic2[i], 2);
        }
        return (int) (dividend / (Math.sqrt(divisor1) * Math.sqrt(divisor2)) * 10000);
    }


}
