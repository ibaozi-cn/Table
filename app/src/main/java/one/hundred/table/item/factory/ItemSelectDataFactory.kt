package one.hundred.table.item.factory

object ItemSelectDataFactory {

    fun getData(selectType: SelectType?, observer: (List<Map<String, String>>) -> Unit) {

        selectType?.let {
            when(it){
                SelectType.TEST->{
                    observer(arrayListOf(
                            mapOf("1" to "有"),
                            mapOf("0" to "无")))
                }
            }
        }

    }

}

enum class SelectType {
    /**
     * TEST
     */
    TEST,
    /**
     * 省
     */
    PROVINCE,
    /**
     * 市
     */
    CITY,
    /**
     * 开户行
     */
    BANK,
    /**
     * 代付款项目
     */
    REPLAY_PAYMENT,
    /**
     * 学位
     */
    Degree,
    /**
     * 学历
     */
    Education,
    /**
     * 证件类型
     */
    IdCardType,
    /**
     * 金融公司
     */
    FinanceCompany,
    /**
     * 门店
     */
    Store,
    /**
     * Yes Or No
     */
    YesOrNo,
    /**
     * Have or No
     */
    HaveOrNo,
    /**
     * 性别
     */
    Sex,
    /**
     * 婚姻状况
     */
    Marriage,
    /**
     * 支付方式
     */
    PayType,
    /**
     * 时间选择
     */
    Time,
    /**
     * 行业
     */
    Industry,
    /**
     * 担保人类型
     */
    GuaranteeType,
    /**
     * 与申请人的关系
     */
    Relation,
    /**
     * 融资期限
     */
    CapitalTerm,
    /**
     * 手续费收取方式
     */
    ProceduresChargeMode,
    /**
     * 订单类型 默认零售客户
     */
    OrderType,
    /**
     * 登记注册号类型
     */
    RegisterNumType,
    /**
     * 组织机构类别
     */
    Organization,
    /**
     * 组织机构类别细分
     */
    OrganizationDetail,
    /**
     * 企业规模
     */
    CompanyScale,
    /**
     * 企业状态 正常、不正常
     */
    CompanyStatus,
    /**
     * 经济类型
     */
    EconomicsType,
    /**
     *  二手车评估机构
     */
    AssessmentMechanism,
    /**
     * 牌证类型
     */
    VehicleBrandCardType,
    /**
     * GPS个数
     */
    GPSNumber,
    /**
     * GPS费用
     */
    GPSPrice,
    /**
     * 房屋证件类型
     */
    HouseCertificatesType,
    /**
     * 房屋与主贷人关系
     */
    HouseRelationship,
    /**
     * 征信人类别
     */
    Relation_Type,
    /**
     * 征信类型
     */
    CreditType,
    /**
     * 贷款银行
     */
    LoanBank,
    /**
     * 业务区域
     */
    BusinessRegion,
    /*
     * 到店拜访车商角色
     */
    VisitRole,
    /**
     * 是 or 否
     * 对应的key 是 true or false
     */
    TrueOrFalse,
    /**
     * 车商认证状态: 已认证、未认证、认证中
     */
    VisitCertificationFlug,
    /**
     * 车商列表
     */
    CarDealer,
    /**
     * 意见个建议
     */
    Suggestions,
    /**
     * 竞对信息中给单原因中的字典
     */
    Competings,
    /**
     * 竞对产品
     */
    Product,
    /**
     * 评价打分,分数
     */
    EvaluationScore,

    /**
     * 评价项
     */
    EvaluationList,
    TextNull,
    /**
     * 云车车型 如：奔驰、宝马
     */
    YunCheCarType,

    /**
     * 云车类别 如：1:国产,2:进口，必填
     */
    YunCheCountry,
    /**
     * 云车上牌地
     */
    YunCheOtcarea,
    /**
     * 云车合作车商
     */
    YunCheDealerid,
    /**
     *  云车婚姻状况
     */
    YunCheMarried,
    /**
     * 云车房屋性质
     */
    YunCheHousetype,
    /**
     * 房主和购车人关系
     */
    YunCheHrelation,
    /**
     * 云车新增性别，与老的字段key不一致，新创建
     */
    YunCheSex,
}
