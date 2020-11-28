package cn.laochou.diagnose.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * 由于FDFS 安装过于麻烦，尝试多次未果。于是开始自己写
 */
@Slf4j
public class FileUtils {


    private static final String prePath = System.getProperty("user.dir") + "/src/main/resources/static/upload/";


    /**
     * 目前正常
     * @param file
     * @return
     */
    public static String uploadFile(MultipartFile file) {
        if(file.isEmpty()) {
            return "";
        }
        // 获取原文件名
        String originFile = file.getOriginalFilename();
        // 这个我们会通过随机进行生成
        String uid = UUID.randomUUID().toString();
        assert originFile != null;
        String suffix = originFile.substring(originFile.lastIndexOf('.') + 1);
        String path = prePath + uid + "." + suffix;
        String returnPath = "/upload/" + uid + "." + suffix;
        File newFile = new File(path);
        if(!newFile.getParentFile().exists()) {
            log.info("创建目录ing");
            newFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnPath;
    }

}
