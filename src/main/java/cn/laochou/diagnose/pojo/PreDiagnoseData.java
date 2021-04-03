package cn.laochou.diagnose.pojo;

/**
 * 预处理的结果存储对象
 */
public class PreDiagnoseData {

    private int symptomsId;

    private String symptomsName;

    private int similarity;

    public int getSymptomsId() {
        return symptomsId;
    }

    public void setSymptomsId(int symptomsId) {
        this.symptomsId = symptomsId;
    }

    public String getSymptomsName() {
        return symptomsName;
    }

    public void setSymptomsName(String symptomsName) {
        this.symptomsName = symptomsName;
    }

    public int getSimilarity() {
        return similarity;
    }

    public void setSimilarity(int similarity) {
        this.similarity = similarity;
    }

    @Override
    public String toString() {
        return "PreDiagnoseData{" +
                "symptomsId=" + symptomsId +
                ", symptomsName='" + symptomsName + '\'' +
                ", similarity=" + similarity +
                '}';
    }
}
