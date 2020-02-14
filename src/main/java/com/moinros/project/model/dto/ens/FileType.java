package com.moinros.project.model.dto.ens;

public enum FileType {

    IMAGE("image", new String[]{"jpg", "jpeg", "gif", "png", "ico", "hdri", "bmp", "pcx", "tiff", "tga", "exif", "fpx", "svg", "psd", "cdr", "pcd", "dxf", "ufo", "eps", "hdri", "ai", "raw", "blob"}),

    MUSIC("music", new String[]{"mp3", "mp2", "mp1", "flac", "wav", "aif", "aiff", "au", "ra", "rm", "ram", "wma"}),

    VIDEO("video", new String[]{"mp4", "avi", "qt", "navi", "webm", "viv", "rm", "rmvb", "3gp", "mov", "m4v", "asx", "wmv", "asf", "asx", "mpeg", "mpg", "dat", "mkv", "flv", "vob", "dv", "divx", "xvid"}),

    JAVA("java", new String[]{"java", "class", "jar", "war", "json"}),

    TXT("txt", new String[]{"txt", "xml", "properties"}),

    HTML("html", new String[]{"html", "js", "css", "htc"}),

    EXE("exe", new String[]{"exe", "cpp", "dll"}),

    DOCX("docx", new String[]{"pdf", "docx", "xlsx"}),

    ISO("iso", new String[]{"iso"}),

    COMPRESSED("compressed", new String[]{"zip", "rar", "7z"}),

    FILE("file", new String[]{"file"}),
    ;

    private String key;

    private String[] code;

    FileType(String key, String[] code) {
        this.key = key;
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public String[] getCode() {
        return code;
    }

}
