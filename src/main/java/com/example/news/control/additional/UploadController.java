package com.example.news.control.additional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
@RestController
public class UploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @PostMapping("/upload")
    public Map<String, Object> fileupload(MultipartFile file, HttpServletRequest req) {
        Map<String, Object> result = new HashMap<>();
        String format = sdf.format(new Date());
//        这种方式不好，文件是死的。路径不好配
        String realPath = req.getServletContext().getRealPath("/static/") + format;
//        String realPath= "src/main/resources/" + "static/file" + format;
        File folder = new File(realPath);
        System.out.println(folder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        assert oldName != null;
        //        可以写文件判断类型
//        if(!oldName.endsWith(".jpg")||!oldName.endsWith(".png")){
//            result.put("status","error");
//            result.put("msg","文件类型不正确");
//            return result;
//        }
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
//        System.out.println(newName);
        try {
            file.transferTo(new File(folder, newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/static/" + format + newName;
//            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + format + newName;
            result.put("status", "OK");
            result.put("name", oldName);
            result.put("url", url);
        } catch (IOException e) {
            result.put("status", "ERROR");
            result.put("msg", e.getMessage());
        }
        return result;
    }
}