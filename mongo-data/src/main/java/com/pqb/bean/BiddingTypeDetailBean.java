package com.pqb.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author bxh
 * @Date: 2022/6/21 14:30
 */
@Data
public class BiddingTypeDetailBean implements Serializable {
    private static final long serialVersionUID = -905279427138679841L;
    @Field("_id")
    private String _id;

    /**
     * <pre>
     *
     * </pre>
     */
    private Integer area_areaid;

    /**
     * <pre>
     *
     * </pre>
     */
    private Integer areaid;

    /**
     * <pre>
     * biddingTypeDetail
     * </pre>
     */
    private BiddingTypeDetail biddingTypeDetail;

    /**
     * <pre>
     *
     * </pre>
     */
    private Integer catid;

    /**
     * <pre>
     *
     * </pre>
     */
    private String character_flag;

    /**
     * <pre>
     * 2.匹配关键词：项目类型
     * </pre>
     */
    private String classification_score;

    /**
     * <pre>
     *
     * </pre>
     */
    private String content;

    /**
     * <pre>
     *
     * </pre>
     */
    private Integer content_flag;

    /**
     * <pre>
     *
     * </pre>
     */
    private Integer createtime;

    /**
     * <pre>
     * dataTagDetail
     * </pre>
     */
    private DataTagDetail dataTagDetail;

    /**
     * <pre>
     * expandField
     * </pre>
     */
    private ExpandField expandField;

    /**
     * <pre>
     * 顺昌县宝山户外运动公共服务设施建设项目
     * </pre>
     */
    private String extract_proj_name;

    /**
     * <pre>
     * 顺昌县宝山旅游开发有限公司
     * </pre>
     */
    private String extract_zhaoBiaoUnit;
    /**
     * 招标详情
     */
    private ZhaoBiaoDetail zhaoBiaoDetail;
    /**
     * 代理机构详情
     */
    private ZhaoBiaoDetail agentDetail;
    /**
     * 中标单位
     */
    private String extract_zhongBiaoUnit;

    private String extract_agentUnit;

    /**
     * <pre>
     *
     * </pre>
     */
    private Integer handletime;

    /**
     * <pre>
     *
     * </pre>
     */
    @Field("id")
    private Integer id;

    /**
     * <pre>
     *
     * </pre>
     */
    private String infoStatus;
    /**
     * 中标金额
     */
    private String extract_amountUnit;

    /**
     * <pre>
     *
     * </pre>
     */
    private String is_projname_engin;

    /**
     * <pre>
     *
     * </pre>
     */
    private String notice_modifytime;

    /**
     * <pre>
     * 顺昌县宝山户外运动公共服务设施建设项目
     * </pre>
     */
    private String originalTitle;

    /**
     * <pre>
     * pot_flag
     * </pre>
     */
    private Pot_flag pot_flag;

    /**
     * <pre>
     *
     * </pre>
     */
    private Integer progid;

    /**
     * <pre>
     * 备案
     * </pre>
     */
    private String project_classification;

    /**
     * <pre>
     * 顺昌县宝山旅游开发有限公司
     * </pre>
     */
    private String project_owner;

    /**
     * <pre>
     * 建设工程规划许可
     * </pre>
     */
    private String project_stage;
    /**
     * 二级细分类
     */
    private String notice_segment_type;
    /**
     * <pre>
     *
     * </pre>
     */
    private String project_xmNumber;

    /**
     * <pre>
     *
     * </pre>
     */
    private String sourceUrl;

    /**
     * <pre>
     * 命中字段：报建,积分情况：阶段：建设工程规划许可,积分：25,阶段：项目计划书批复,积分：0,
     * </pre>
     */
    private String stage_score;

    /**
     * <pre>
     * 顺昌县宝山户外运动公共服务设施建设项目
     * </pre>
     */
    private String title;

    /**
     * <pre>
     *
     * </pre>
     */
    private String to_publishtime;

    /**
     * <pre>
     *
     * </pre>
     */
    private Integer typeid;

    /**
     * <pre>
     *
     * </pre>
     */
    private Long updatetime;

    /**
     * <pre>
     *
     * </pre>
     */
    private String url;

    /**
     * <pre>
     *
     * </pre>
     */
    private String xmNumber;

    /**
     * <pre>
     * zhaobiao_unit_nature
     * </pre>
     */
    private Zhaobiao_unit_nature zhaobiao_unit_nature;
    /**
     * 项目投资，catid =301、601才会提取
     */
    private String project_invest;
    /**
     * 总投资
     */
    private String extract_total_investment;
    /**
     * 预算金额
     */
    private String extract_budget;
    /**
     * 项目性质 catid =301、601才会提取
     */
    private String project_nature;
    /**
     * 工期字段
     */
    private String extract_period;

    private List<String> section;
    /**
     * 附件地址
     */
    private String block;

    private List<List<Attachment_content_details>> attachment_content_details;
    @Data
    public static class Zhaobiao_unit_nature implements Serializable {
        private static final long serialVersionUID = -4037825184951632037L;

        /**
         * <pre>
         * 商业公司
         * </pre>
         */
        private String first_nature;

        /**
         * <pre>
         * 旅游
         * </pre>
         */
        private String second_nature;
    }
    @Data
    public static class Pot_flag implements Serializable{

        /**
         * <pre>
         *
         * </pre>
         */
        private String ecp_flag;

        /**
         * <pre>
         *
         * </pre>
         */
        private String emall_flag;
    }

    @Data
    public static class Attachment_content_details implements Serializable{
        private String fileName;
    }


    @Data
    public static class ExpandField implements Serializable {

        private static final long serialVersionUID = -2190116506257291677L;
        /**
         * <pre>
         * tenderees
         * </pre>
         */
        private List<String> tenderees;
    }
    @Data
    public static class DataTagDetail implements Serializable {

        private static final long serialVersionUID = 4211406921054743670L;
        /**
         * <pre>
         * notice_types
         * </pre>
         */
        private List<String> notice_types;
    }
    @Data
    public static class BiddingTypeDetail implements Serializable {

        private static final long serialVersionUID = 1795490364426775823L;
        /**
         * <pre>
         *
         * </pre>
         */
        private Integer bidding_type;

        /**
         * <pre>
         *
         * </pre>
         */
        private Integer is_electronic;
    }
    @Data
    public static class ZhaoBiaoDetail implements Serializable{
        /**
         * 业主姓名
         */
        private String relationName;
        /**
         * 业主联系方式
         */
        private String relationWay;
    }

}
