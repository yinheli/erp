package com.nzonly.erp.entity;

import java.util.Date;

/**
 * 订单结构
 * @author Matthew
 *
 */
public class
		Order extends BaseEntity {
	
	private static final long serialVersionUID = 3466660029813242924L;

	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 子订单编号
	 */
	private Long oid;

	/**
	 * 订单状态（请关注此状态，如果为TRADE_CLOSED_BY_TAOBAO状态，则不要对此订单进行发货，切记啊！）。可选值:
	 * TRADE_NO_CREATE_PAY(没有创建支付宝交易)
	 * WAIT_BUYER_PAY(等待买家付款)
	 * WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款)
	 * WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货)
	 * TRADE_BUYER_SIGNED(买家已签收,货到付款专用)
	 * TRADE_FINISHED(交易成功)
	 * TRADE_CLOSED(付款以后用户退款成功，交易自动关闭)
	 * TRADE_CLOSED_BY_TAOBAO(付款以前，卖家或买家主动关闭交易)
	 */
	private String status;
	
	/**
	 * 商品标题
	 */
    private String title;
    
    /**
     * 商品价格。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    private String price;

    /**
     * 商品数字ID
     */
    private Long numIid;

    /**
     * 套餐ID
     */
    private Long itemMealId;
  
    /**
     * 购买数量。取值范围:大于零的整数
     */
    private Integer num;

    /**
     * 外部网店自己定义的Sku编号
     */
    private String outerSkuId;
    
    /**
     * 子订单来源,如jhs(聚划算)、taobao(淘宝)、wap(无线)
     */
    private String orderFrom;
    
    /**
     * 应付金额（商品价格 * 商品数量 + 手工调整金额 - 订单优惠金额）。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    private String totalFee;
    
    /**
     * 子订单实付金额。精确到2位小数，单位:元。如:200.07，表示:200元7分。计算公式如下：payment = price * num + adjust_fee - discount_fee + post_fee(邮费，单笔子订单时子订单实付金额包含邮费，多笔子订单时不包含邮费)；对于退款成功的子订单，由于主订单的优惠分摊金额，会造成该字段可能不为0.00元。建议使用退款前的实付金额减去退款单中的实际退款金额计算。
     */
    private String payment;

    /**
     * 订单优惠金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    private String discountFee;


    /**
     * 手工调整金额.格式为:1.01;单位:元;精确到小数点后两位.
     */
    private String adjustFee;
    
    /**
     * 订单修改时间，目前只有taobao.trade.ordersku.update会返回此字段。
     */
    private Date modified;
    
    /**
     * 最近退款ID
     */
    private Long refundId;
    
	/**
	 * 子订单的交易结束时间 说明：子订单有单独的结束时间，与主订单的结束时间可能有所不同，在有退款发起的时候或者是主订单分阶段付款的时候，子订单的结束时间会早于主订单的结束时间，所以开放这个字段便于订单结束状态的判断
	 */
	private Date endTime;
	
	/**
	 * 套餐的值。如：M8原装电池:便携支架:M8专用座充:莫凡保护袋
	 */
	private String itemMealName;

	/**
	 * 商品图片的绝对路径
	 */
	private String picPath;

	/**
	 * 买家昵称
	 */
	private String buyerNick;
	
	/**
	 * 退款状态。退款状态。可选值 WAIT_SELLER_AGREE(买家已经申请退款，等待卖家同意) WAIT_BUYER_RETURN_GOODS(卖家已经同意退款，等待买家退货) WAIT_SELLER_CONFIRM_GOODS(买家已经退货，等待卖家确认收货) SELLER_REFUSE_BUYER(卖家拒绝退款) CLOSED(退款关闭) SUCCESS(退款成功)
	 */
	private String refundStatus;

	/**
	 * 商家外部编码(可与商家外部系统对接)。外部商家自己定义的商品Item的id，可以通过taobao.items.custom.get获取商品的Item的信息
	 */
	private String outerIid;

	/**
	 * 订单快照URL
	 */
	private String snapshotUrl;

	/**
	 * 订单快照详细信息
	 */
    private String snapshot;
    
    /**
	 * 超时到期时间。格式:yyyy-MM-dd HH:mm:ss。业务规则： 前提条件：只有在买家已付款，卖家已发货的情况下才有效 如果申请了退款，那么超时会落在子订单上；比如说3笔ABC，A申请了，那么返回的是BC的列表, 主定单不存在 如果没有申请过退款，那么超时会挂在主定单上；比如ABC，返回主定单，ABC的超时和主定单相同
	 */
	private Date timeoutActionTime;
	
	/**
	 * 买家是否已评价。可选值:true(已评价),false(未评价)。如买家只评价未打分，此字段仍返回false
	 */
	private String buyerRate;
	
	/**
	 * 卖家是否已评价。可选值:true(已评价),false(未评价)
	 */
	private String sellerRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Long getNumIid() {
		return numIid;
	}

	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}

	public Long getItemMealId() {
		return itemMealId;
	}

	public void setItemMealId(Long itemMealId) {
		this.itemMealId = itemMealId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getOuterSkuId() {
		return outerSkuId;
	}

	public void setOuterSkuId(String outerSkuId) {
		this.outerSkuId = outerSkuId;
	}

	public String getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(String orderFrom) {
		this.orderFrom = orderFrom;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(String discountFee) {
		this.discountFee = discountFee;
	}

	public String getAdjustFee() {
		return adjustFee;
	}

	public void setAdjustFee(String adjustFee) {
		this.adjustFee = adjustFee;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Long getRefundId() {
		return refundId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getItemMealName() {
		return itemMealName;
	}

	public void setItemMealName(String itemMealName) {
		this.itemMealName = itemMealName;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getOuterIid() {
		return outerIid;
	}

	public void setOuterIid(String outerIid) {
		this.outerIid = outerIid;
	}

	public String getSnapshotUrl() {
		return snapshotUrl;
	}

	public void setSnapshotUrl(String snapshotUrl) {
		this.snapshotUrl = snapshotUrl;
	}

	public String getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}

	public Date getTimeoutActionTime() {
		return timeoutActionTime;
	}

	public void setTimeoutActionTime(Date timeoutActionTime) {
		this.timeoutActionTime = timeoutActionTime;
	}

	public String getBuyerRate() {
		return buyerRate;
	}

	public void setBuyerRate(String buyerRate) {
		this.buyerRate = buyerRate;
	}

	public String getSellerRate() {
		return sellerRate;
	}

	public void setSellerRate(String sellerRate) {
		this.sellerRate = sellerRate;
	}

}
