package cn.laochou.diagnose.util;

import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传工具类
 */
@Component
public class FdfsUtils {


    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private FdfsWebServer fdfsWebServer;


    public String uploadFile(MultipartFile file) {
        try {
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            String fullPath = storePath.getFullPath();
            return getResAccessUrl(fullPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    // 封装文件完整URL地址
    public String getResAccessUrl(String path) {
        String url = fdfsWebServer.getWebServerUrl() + path;
        System.out.println("上传文件地址为：\n" + url);
        return url;
    }

}
