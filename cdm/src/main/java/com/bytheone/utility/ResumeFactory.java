package com.bytheone.utility;

import com.bytheone.entity.ResumeType;
import com.bytheone.entity.SysSource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Email Manager
 */
class ResumeFactory {


    private final String CONFIG_FOLDER_PATH = String.format("%s/cdm-sys/src/main/resources/config/", System.getProperty("user.dir"));

    SysSource parseEmail(String mailId, String messageText, ResumeType resumeType) {

        Document document = Jsoup.parse(messageText);

        System.out.println(String.format("邮件标题是：%s", document.title()));
        SysSource resume = new SysSource();
        Byte sourceType = null;

        /*
        <option value="0">前程无忧</option>
        <option value="1">智联招聘</option>
        <option value="2">中华英才</option>
        <option value="3">大街招聘</option>
        <option value="4">人才热线</option>
        <option value="5">自主添加</option>
        */

        switch (resumeType) {
            case CJOL:
                sourceType = 4;
                resume = this.parseCjol(mailId, messageText);
                break;
            case GANJI:
                sourceType = 6;
                resume = this.parseGanji(mailId, messageText);
                break;
            case JOB51:
                sourceType = 0;
                resume = this.parseJob51(mailId, messageText);
                break;
            case DAJIE:
                sourceType = 3;
                resume = this.parseDajie(mailId, messageText);
                break;
            case CITY58:
                sourceType = 7;
                resume = this.parseCity58(mailId, messageText);
                break;
            case CHINAHR:
                sourceType = 2;
                resume = this.parseChinahr(mailId, messageText);
                break;
            case ZHILIAN:
                sourceType = 1;
                resume = this.parseZhilian(mailId, messageText);
                break;

        }
        resume.setSourceType(sourceType);


        System.out.println(resume.toString());
        return resume;


    }

    /**
     * 根据发件人判断邮件类型
     *
     * @param from 收件人
     * @return resume Type
     */
    ResumeType parseEmailType(String from) {
        ResumeType resumeType = ResumeType.DEFAULT;
        if (from.contains("@email.cjol.com")) {
            resumeType = ResumeType.CJOL;
        }
        if (from.contains("@quickmail.51job.com>")) {
            resumeType = ResumeType.JOB51;
        }
        if (from.contains("@zhaopinmail.com")) {
            resumeType = ResumeType.ZHILIAN;
        }
        if (from.contains("@send.ganji.com")) {
            resumeType = ResumeType.GANJI;
        }
        if (from.contains("@sysmail.dajie.com")) {
            resumeType = ResumeType.DAJIE;
        }
        if (from.contains("@info.chinahr.com")) {
            resumeType = ResumeType.CHINAHR;
        }
        if (from.contains("@zp.58.com")) {
            resumeType = ResumeType.CITY58;
        }
        return resumeType;
    }

    private SysSource parseZhilian(String mailId, String messageText) {
        SysSource resume = new SysSource();
        String ZHILIAN_SELECTOR_FILE_NAME = "ZhilianSelector.yaml";
        Map config = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + ZHILIAN_SELECTOR_FILE_NAME);
        this.setSysSourceValue(mailId, resume, config, messageText);

        return resume;

    }

    private SysSource parseJob51(String mailId, String messageText) {
        SysSource resume = new SysSource();
        String JOB51_SELECTOR_FILE_NAME = "Job51Selector.yaml";
        Map config = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + JOB51_SELECTOR_FILE_NAME);
        this.setSysSourceValue(mailId, resume, config, messageText);

        return resume;
    }

    private SysSource parseCjol(String mailId, String messageText) {
        SysSource resume = new SysSource();
        String CJOL_SELECTOR_FILE_NAME = "CjolSelector.yaml";
        Map config = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + CJOL_SELECTOR_FILE_NAME);
        this.setSysSourceValue(mailId, resume, config, messageText);

        return resume;
    }

    private SysSource parseChinahr(String mailId, String messageText) {
        SysSource resume = new SysSource();
        String CHINAHR_SELECTOR_FILE_NAME = "ChinahrSelector.yaml";
        Map config = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + CHINAHR_SELECTOR_FILE_NAME);
        this.setSysSourceValue(mailId, resume, config, messageText);

        return resume;
    }

    private SysSource parseGanji(String mailId, String messageText) {
        SysSource resume = new SysSource();
        String GANJI_SELECTOR_FILE_NAME = "GanjiSelector.yaml";
        Map config = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + GANJI_SELECTOR_FILE_NAME);
        this.setSysSourceValue(mailId, resume, config, messageText);

        return resume;
    }

    private SysSource parseCity58(String mailId, String messageText) {
        SysSource resume = new SysSource();
        String CITY58_SELECTOR_FILE_NAME = "City58Selector.yaml";
        Map config = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + CITY58_SELECTOR_FILE_NAME);
        this.setSysSourceValue(mailId, resume, config, messageText);

        return resume;
    }

    private SysSource parseDajie(String mailId, String messageText) {
        SysSource resume = new SysSource();
        String DAJIE_SELECTOR_FILE_NAME = "DajieSelector.yaml";
        Map config = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + DAJIE_SELECTOR_FILE_NAME);
        this.setSysSourceValue(mailId, resume, config, messageText);

        return resume;
    }

    private String getElementText(String messageText, Map config, String key) {
        String elementText = null;
        String selector = YamlHelper.getMapValue(config, key);
        Document document = Jsoup.parse(messageText);
        if (selector != null && document != null && !selector.equals("")) {
            Element element = document.selectFirst(selector);
            if (element != null) {
                elementText = element.text();
            } else {
                elementText = null;
            }
        }

        return elementText;
    }

    private void setSysSourceValue(String mailId, SysSource resume, Map config, String messageText) {
        if (config != null && resume != null) {

            resume.setId(mailId);

            String NAME_KEY = "Name";
            String nameText = getElementText(messageText, config, NAME_KEY);
            resume.setName(nameText != null ? nameText.trim() : null);

            String AGE_KEY = "Age";
            String ageText = getElementText(messageText, config, AGE_KEY);
            if (ageText != null) {
                ageText = ageText.contains("岁") ?
                        ageText.substring(ageText.indexOf("岁") < 3 ? ageText.indexOf("岁") - 2 : ageText.indexOf("岁") - 3, ageText.indexOf("岁") - 1) : ageText;
                resume.setAge(ageText.trim());
            }

            String GENDER_KEY = "Gender";
            String genderText = getElementText(messageText, config, GENDER_KEY);
            if (genderText != null) {
                if (genderText.contains("男")) {
                    genderText = "男";
                } else {
                    genderText = "女";
                }
                resume.setGender(genderText.trim());
            }

            String EMAIL_KEY = "Email";
            String emailText = getElementText(messageText, config, EMAIL_KEY);
            if (emailText != null) {
                emailText = emailText.contains("邮") ? emailText.replace("邮", "") : emailText;
                emailText = emailText.contains("件") ? emailText.replace("件", "") : emailText;
                emailText = emailText.contains("箱") ? emailText.replace("箱", "") : emailText;
                emailText = emailText.contains("：") ? emailText.replace("：", "") : emailText;
                resume.setEmail(emailText.trim());
            }


            String MOBILE_KEY = "Mobile";
            String mobileText = getElementText(messageText, config, MOBILE_KEY);
            if (mobileText != null) {
                mobileText = mobileText.contains("手") ? mobileText.replace("手", "") : mobileText;
                mobileText = mobileText.contains("机") ? mobileText.replace("机", "") : mobileText;
                mobileText = mobileText.contains("：") ? mobileText.replace("：", "") : mobileText;

                resume.setMobile(mobileText.trim());
            }

            String HUKOU_KEY = "Hukou";
            String hukouText = getElementText(messageText, config, HUKOU_KEY);
            resume.setHukou(hukouText != null ? hukouText.trim() : null);

            String LOCATION_KEY = "Location";
            String locationText = getElementText(messageText, config, LOCATION_KEY);
            resume.setLocation(locationText != null ? locationText.trim() : null);

            String SCHOOL_KEY = "School";
            String schoolText = getElementText(messageText, config, SCHOOL_KEY);
            resume.setSchool(schoolText != null ? schoolText.trim() : null);

            String EDUCATION_KEY = "Education";
            String educationText = getElementText(messageText, config, EDUCATION_KEY);
            resume.setEducation(educationText != null ? educationText.trim() : null);

            String CAREER_KEY = "Career";
            String careerText = getElementText(messageText, config, CAREER_KEY);
            resume.setCareer(careerText != null ? careerText.trim() : null);

            String PROJECT_EXPERIENCE_KEY = "ProjectExperience";
            String projectExperienceText = getElementText(messageText, config, PROJECT_EXPERIENCE_KEY);
            resume.setProject(projectExperienceText != null ? projectExperienceText.trim() : null);

            String EDUCATION_BACKGROUND_KEY = "EducationBackground";
            String educationBackgroundText = getElementText(messageText, config, EDUCATION_BACKGROUND_KEY);
            resume.setEducation(educationBackgroundText != null ? educationBackgroundText.trim() : null);

            String GRADUATE_DATE_KEY = "GraduateDate";
            String graduateDateText = getElementText(messageText, config, GRADUATE_DATE_KEY);
            if (graduateDateText != null && graduateDateText.contains("-")) {
                graduateDateText = graduateDateText.substring(graduateDateText.indexOf("-"));
                try {
                    if (graduateDateText.contains("至今")) {
                        graduateDateText = "2018/07";
                    }
                    resume.setGraduateDate(new SimpleDateFormat("yyyy/mm").parse(graduateDateText));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            String TECHNICAL_SKILLS_KEY = "TechnicalSkills";
            String technicalSkillsText = getElementText(messageText, config, TECHNICAL_SKILLS_KEY);
            resume.setSkills(technicalSkillsText != null ? technicalSkillsText.trim() : null);

            String APPLIED_POSITION_KEY = "AppliedPosition";
            String appliedPositionText = getElementText(messageText, config, APPLIED_POSITION_KEY);

            if (appliedPositionText != null && appliedPositionText.contains("[") && appliedPositionText.contains("]")) {
                String RESUME_SOURCE_TYPE_FILE_NAME = "ResumeSourceType.yaml";
                Map resumeSourceTypeMap = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + RESUME_SOURCE_TYPE_FILE_NAME);

                int start = appliedPositionText.indexOf("[") + 1;
                int end = appliedPositionText.indexOf("]");
                String id = appliedPositionText.substring(start, end);

                if (id.startsWith("S")) {
                    resume.setPosition("深圳" + id);
                }
                if (id.startsWith("D")) {
                    resume.setPosition("东莞" + id);
                }
                if (id.startsWith("H")) {
                    resume.setPosition("惠州" + id);
                }


                resume.setSourceDetail(YamlHelper.getMapValue(resumeSourceTypeMap, id));
            } else {
                resume.setPosition(appliedPositionText != null ? appliedPositionText.trim() : null);
            }

            String REMARK_KEY = "Remark";
            String remarkText = getElementText(messageText, config, REMARK_KEY);
            resume.setRemark(remarkText != null ? remarkText.trim() : null);

            resume.setUrl(String.format("http://www.cdtest.pro:8668/cds/resume/resume_%s.html", mailId));


        }
    }


}
