package test;

import org.mybatis.generator.api.ShellRunner;

/**
 * @author ArtLinty
 * @date 2017/12/4.
 * @email liu.tingli@qq.com
 */
public class MybatisApp {

    public static void main(String[] args) {
        args = new String[]{"-configfile", "bytheone-web\\src\\main\\resources\\auto-config\\mybatis-config.xml", "-overwrite"};
        ShellRunner.main(args);
    }

}
