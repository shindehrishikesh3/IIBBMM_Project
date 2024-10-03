package Translation.APAC_Countries;

import java.util.HashMap;

public class CN_Translation {

    // ############China############

    public String cnTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("5 business days delivery for in stock items", "");
            map.put("Hi. Login / Register", "您好，登入 / 註冊：");
            map.put("Log In", "登录");
            map.put("Buying Tools", "购买工具");
            map.put("My Profile", "我的配置文件");
            map.put("Log In | Register ont | Log t", "Log ind | Registrer ont | Log t");
            map.put("Back to Main Menu", "返回主菜单");
            map.put("Back to Connectors & Cable", "返回至 连接器与电缆");
            map.put("Back to Connectors", "返回至 连接器");
            map.put(
                "You only get charged when the products are dispatched to you.",
                "只有在发货后才会收取您的费用。"
            );
            map.put("0 items", "0 物品");
            map.put("1 items", "1 物品");
            map.put("You can reserve stock now", "您现在可以预订货品了");
            // PDP Messages
            map.put(
                "Order before 8pm within mainland UK & 6pm in Northern Ireland",
                "英国本土下午 8 点前下单，北爱尔兰下午 6 点前下单"
            );
            map.put(
                "Order before 8pm EST standard shipping",
                "东部标准时间下午 8 点前下单按标准时间发货"
            );
            map.put(
                "US stock items are coming from our US warehouse.",
                "	美國庫存項目從美國倉庫送出。"
            );
            map.put("This item can't be cancelled or returned", "本物品无法取消或退货");
            map.put("next business day", "下一个工作日交货");
            map.put("Available for next business day delivery", "下一个工作日送货");
            map.put(
                "US stock items are coming from our US warehouse.",
                "运费：每个订单每次 £15.95。"
            );
            map.put("With you in", "以下天数内交货");
            map.put("Same day shipping", "当天发货");
            map.put("With you next business day", "下一个工作日交货");
            map.put("More delivery information", "更多送货信息");
            map.put(
                "To bring this product to you we need to ship between our international warehouses.",
                "我们需要通过国际仓库为您发货。"
            );
            map.put("Message for Non-Vat Customer", "针对非增值税客户的消息");
            map.put("Remove", "删除");
            map.put("Items", " 个物品");

            map.put("Available for back order", "可延期交货");
            map.put("Notify me when back in stock", "有货时请通知我");
            map.put("Show all similar products", "显示所有类似产品");
            map.put("Need more?", "需要更多？");
            map.put("View cut-off times", "查看交货截止时间");
            map.put("No Longer Stocked", "不再進貨");
            map.put("No Longer Manufactured", "已停产");
            map.put("Deliveries start from", "送货开始日期");
            map.put(
                "More stock available to supplier lead times which is approximately",
                "交付周期内将会有更多库存，大约为"
            );
            map.put(
                "You can reserve stock now just order your desired quantity and checkout as normal. The quantity that cant be dispatched now will be placed on back order and sent as soon as we get a delivery from our supplier. You only get charged when the products are dispatched to you.",
                "您现在可以预订货品了 订购所需的数量并按正常方式结算。目前无法交付的数量将列入延期交货订单中，并在到货后立即发货。 只有在发货后才会收取您的费用。\r\n" +
                "\r\n" +
                ""
            );

            // New Text for Sprint 8
            map.put("Checkout Now", "立即结算");
            // map.put("Availability", "库存数");
            map.put("New - 7 Days", "新 - 7 天");
            map.put("New - 180 Days", "新 - 180 天");

            map.put("New", "新");
            map.put("0 Filter(s) Selected", "0 已选择 个筛选条件");
            map.put("1 Filter(s) Selected", "1 已选择 个筛选条件");
            map.put("1 Filter Applied", "1 已应用  个筛选器");
            map.put("All Products", "所有产品");
            map.put("New Products", "新建产品");
            map.put("Manufacturers", "制造商");
            map.put("Manufacturer", "制造商");
            map.put("IoT Hub", "IoT 集线器");
            map.put("Resources", "资源");
            map.put("View All Products", "查看所有产品");
            map.put("Passives", "无源元件");
            map.put("Connectors & Cable", "连接器与电缆");
            map.put("Semiconductors", "半导体");
            map.put(
                "Optoelectronics & LED Lighting Components",
                "光电产品与 LED 照明组件"
            );
            map.put("Electromechanical", "机电产品");
            map.put("Automation & Process Control", "自动化与过程控制");
            map.put(
                "Development Tools, Software & Embedded Computers",
                "开发工具与原型设计配件"
            );
            map.put("Power Supplies and Circuit Protection", "电源和电路保护");
            map.put("Test & Measurement", "测试与测量设备");
            map.put("Tools & Production supplies", "工具与生产用具");

            map.put("Non-Cancellable / Non Returnable", "不可取消/不可退货");

            // Sprint 9
            map.put("Next", "下一步");
            map.put("Best Seller", "畅销品");
            map.put("available for", "可于");
            map.put(
                "/prl/results?sort=P_INVENTORY&pageSize=100",
                "/prl/results?sort=P_INVENTORY&pageSize=100"
            );
            map.put("/prl/results", "/prl/results");
            map.put("Previous", "上一步");
            map.put("is a discontinued item with a limited inventory of", "是具有");
            map.put(
                "The quantity in your basket has been adjusted accordingly.",
                "件有限库存的已终止物品。 购物篮中的数量已相应调整。"
            );
            map.put(
                " will be placed on backorder. You won't be charged for back order items until they are despatch to you",
                " 将被列入缺货商品名单. {0} 将被列入缺货商品名单"
            );
            map.put("see cut-off times", "查看交货截止时间");
            map.put("Available until stock is exhausted", "该库存量售罄后，将不再备货");
            map.put("View all", "查看全部");
            map.put("Description / Manufacturer", "说明 / 制造商");
            map.put("Supplier Direct Ship", "供应商直接发货");

            map.put("Order Total", "订单合计");
            map.put("All Items Total (excl VAT):", "货物小计:");
            map.put("Delivery:", "送达:");
            map.put("VAT:", "增值税:");
            map.put("Total:", "合计:");
            map.put("£", "CNY");
            map.put("ViewAll@STM3_32", "查看全部");

            // sprint 10
            map.put("< Home", "< 首页");
            map.put("browse-for-products", "browse-for-products");
            map.put("IoT Overview", "IoT 概述");
            map.put(
                "Collect - Edge Devices (Sensors and Actuators)",
                "收集 - 边缘设备（传感器和执行器）"
            );
            map.put("Connectivity - Wireless", "连接 – 无线");
            map.put("Control - Gateways", "控制 – 网关");
            map.put("Cloud - Data Centre", "云 - 数据中心");
            map.put("see cut-off times", "查看交货截止时间");
            map.put("In stock", "有货");
            map.put("Manufacturer Part No", "制造商产品编号");
            map.put("Order Code:", "库存编号");
            map.put("Country of Origin:", "原产地：");
            map.put("RoHS Compliant:", "RoHS 合规：");
            map.put("Technical Datasheet", "技术数据表");
            // Geolocation msgs

            map.put("Yes", "是");
            map.put("No", "否");
            map.put("Choose country", "更改国家/地区");
            map.put(
                "Would you like to go to our Australian website?",
                "您是否希望访问简体中文网站？"
            );
            map.put(
                "Remember this choice and automatically redirect me in the future",
                "记住此选择，以后设为默认选择"
            );

            // pdpPage product information section

            map.put(
                "Want to see similar products? Simply select your required attributes below and hit the button",
                "想要查看类似产品？只需在下方选择所需属性并点击按钮"
            );
            map.put("Product Information", "产品信息");
            map.put("Find similar products", "查找类似产品");
            map.put(
                "Choose and modify the attributes above to find similar products.",
                "选择并修改以上属性即可查找类似产品。"
            );
            map.put("Filter Tool", "筛选器工具");
            map.put("Apply Filters", "应用过滤器");
            map.put("Close", "关闭");
            map.put("Show Results", "显示 个结果");

            // decimal fraction page
            map.put("Fraction and Decimal Conversion Table", "小数和分数换算表");
            map.put("Decimal and Fraction Conversion", "小数和分数换算");
            map.put("Fraction", "分数");
            map.put("Equivalent Fractions", "相等分数");
            map.put("Decimal", "小数");
            map.put("Calculators & Conversion Charts", "计算器和换算表");

            // PDP sprint 11
            map.put("Price", "标价，不含增值税（含增值税）");
            map.put("Availability", "库存数");
            map.put("Product Information", "产品信息");
            map.put("Product Overview", "产品概述");
            map.put("Technical Documents", "技术文档");
            map.put("Legislation and Environmental", "法律与环境");
            map.put("Community", "社区");
            map.put("Price for:", "包装规格：");
            map.put("Minimum order quantity:", "最少订单数量：");
            map.put("Order multiple quantity:", "多重订单数量：");
            map.put("Price:", "单价");
            map.put("Quantity", "数量");
            map.put("Contact me when back in stock", "再次有货时请联系我");
            map.put("Calculators & Conversion Charts", "计算器和换算表");
            map.put("Manufacturer List", "制造商列表");
            map.put("Internet of Things", "物联网");
            map.put(
                "Collect - Edge Devices (Sensors & Actuators)",
                "收集 - 边缘设备（传感器和执行器）"
            );
            map.put("Wireless", "无线通信");
            map.put("Control - Gateway", "控制 - 网关");

            map.put("Products Found", "件产品");
            map.put("List Price", "单价（含增值税）");
            map.put("List Price Ex. VAT (Inc. VAT)", "标价，不含增值税（含增值税）");
            map.put("List Price Ex. GST (Inc. GST)", "标价，不含增值税（含增值税）");

            // moq story
            map.put("Add", "添加");
            map.put("Minimum order of", "最少订购");
            map.put("items", "个商品");

            // Sprint 13 Translations for STM282
            map.put("Lighting Products", "照明产品");
            map.put("View All Lighting Products", "查看全部 照明产品");
            map.put("Lamps & Tubes", "灯和灯管");
            map.put("Lighting Product Accessories", "照明产品配件");
            map.put("LED Light Bars", "LED灯条");
            map.put("Task & Inspection Lighting", "射灯");
            map.put("Downlighting", "泛光灯");
            map.put("Bulkhead Lighting", "LED恶劣环境照明灯");
            map.put("Floodlights", "舱壁灯");
            map.put("Specialty Lighting", "任务&视检灯");
            map.put("Lighting Product Accessories ", "Lighting Product Accessories");
            map.put("Optoelectronics & Displays", "光电子与显示器");
            map.put("Security & Audio Visual", "安全管理与音视频");

            map.put("Share this page", "");
            map.put("Live Technical Chat", "");
            map.put("Help Centre", "帮助中心");
            map.put("Quick Access Links", "快速访问链接");
            map.put("Applications", "应用");
            map.put("Services", "服务");
            map.put("Technologies", "技术");
            map.put("Help", "帮助");
            // resources
            map.put("Cloud – Data Centre", "云 - 数据中心");
            map.put("Change country", "Change country");
            map.put("Categories", "类别");
            map.put("Show All Products", "显示所有产品");
            map.put("Please enter a valid quantity", "请输入一个有效的数量");
            map.put("Multiples of", "只能是");
            map.put("only", "的倍数");
            // Sprint 13 web PLP
            map.put("Remember", "记忆");
            map.put("Filters Applied", "已应用个筛选器");
            map.put("Clear All Filters", "清除所有筛选");
            map.put("Show  Results", "显示  个结果");
            map.put("Here are some associated products", "下面是一些关联产品");
            map.put("More Pricing...", "更多价格信息...");
            map.put("Price (Incl GST)", "单价（含增值税）");
            map.put("Associated Products", "关联产品");
            map.put("Add", "添加");
            map.put("Back Order", "延期发货");
            map.put("Add to Basket", "添加到购物篮");
            map.put("Pre-Order", "预订");
            // Sprint 14 team 2 reg
            map.put("1 items", "1 物品");
            map.put("Print Page", "打印页面");
            map.put("Sort By", "排序方式");
            map.put("Clear All", "全部清除");
            map.put("Remove 0 Items", "删除 0 个物品");
            map.put("Order Code", "输入库存编号");
            map.put("Quantity", "数量");
            map.put("Enter Your Part No/Line Note", "添加部件编号/注释行");
            map.put("Your Part No", "您的零件号");
            map.put("Line Note", "备注");
            map.put("Update", "更新");
            map.put("Delete", "删除");
            map.put("Unit Price (excl GST):", "单价 (不含增值税):");
            map.put("Line Price (excl GST):", "总价 (不含增值税):");
            map.put(
                "Enter order code and qty, then press Update Basket.",
                "输入库存编号和数量，然后按“更新购物篮”。"
            );
            map.put("Add All to Favourites", "全部收藏产品");
            map.put("Load / Save Basket", "加载/保存购物篮");
            map.put("Download basket", "下载购物篮");
            map.put("Update Basket", "更新购物篮");
            map.put("Or pay with a Trade account", "或使用交易帐户支付");
            map.put(
                "*Calculated based on your preferences or selected shipping",
                "*根据您的首选项或所选送货方式计算"
            );
            map.put("Create Schedule", "送货日程安排");
            map.put("Add", "添加");
            map.put("Add voucher code", "添加购物券代码");
            map.put("Shopping Basket", "购物篮");
            map.put("0 items", "0 物品");
            map.put("Download as PDF", "以 PDF 格式下载");
            map.put("Add more items by order code", " 按订单代码添加更多商品");
            map.put("Returning Customer", "老客户");
            map.put("Your Basket is Empty", "您的购物篮为空");

            map.put("Log In", "登录");
            map.put("Register Now", "立即注册");
            map.put(
                "To create an order schedule you need to be logged in. Not available for guest checkout users",
                "请登录网站以创建订购计划。访客结账用户无法使用该功能"
            );
            map.put("Compare Selected", "比较选定的物品");
            map.put("Categories", "类别");
            map.put("Extended Attributes", "扩展属性");
            map.put("Show  Results", "显示  个结果");

            map.put("Clear All Filters", "清除所有筛选");
            map.put("Pack Size", "每包件数");
            map.put("pack size", "每包件数");
            map.put("pack size of", "的最小包装为");
            map.put("Quantity", "数量");

            // Sprint 15 Mobile -Team3

            map.put("Shopping Cart", "购物篮");
            map.put("My Account", "我的帐户");
            map.put("Order Status", "订单状态和跟踪");
            map.put("Contact Us", "联系我们");
            map.put("About Us", "关于我们");
            map.put("Checkout Now", "立即结算");
            map.put("Contact Us", "联系我们");
            // Agile Team 2 Sprint 15
            map.put(
                "You can compare up to 10 products at a time. The most recent 10 products will be shown.",
                "个产品。您一次最多可比较 10 个产品。将显示最近的 10 个产品。"
            );
            map.put("Order Details", "订单详细信息");

            // Team 5 BOM page UI
            map.put(
                "Items that have an exact match will appear in the table below. Some items may have more than one match or no matches. You can manually search for and choose the item that best matches by following the directions below;",
                "具有精确匹配的项目将出现在下表中。 有些项目可能有多个匹配项或者无匹配项。 您可以按照以下说明手动搜索和选择最佳匹配项；"
            );
            map.put(
                "For Multiple matches — Click 'View all results' button and select the best matched item from the list.",
                " 对于多个匹配项 — 点击“查看所有结果”按钮，然后从列表中选择最佳匹配项。"
            );
            map.put(
                "For No matches — Modify your search by changing the existing term or entering a new store part number, manufacturer part number / name, or description.\"",
                "对于无匹配项 — 通过更改现有词条或输入新的存储部件号、制造商部件号/名称或描述来修改您的搜索条件。"
            );
            map.put("Minimum", "最低要求");
            map.put("Multiples of", "的倍数");
            map.put("Alternatives for", "显示所有类似产品");
            map.put("Log In", "登录");
            map.put("Username", "用户名");
            map.put("Password", "密码");
            map.put("Problems logging in", "登录时出现问题");
            map.put("Forgotten your username?", "忘记用户名？");
            map.put("Forgotten your password?", "忘记密码？");
            map.put("Don't have an account?", "没有账户？");
            map.put("Register", "注册");
            map.put("Go to Basket", "前往购物篮");
            map.put("- Enter your username", "- 输入用户名");
            map.put("Enter your username", "输入用户名");
            map.put("- Enter your password", "- 输入密码");
            map.put("Enter your password", "输入密码");
            map.put(
                "Either the username or password is incorrect. Please check and re-enter the information again",
                "用户名或密码错误。请检查并重新输入信息。"
            );
            map.put("There is a problem with the following", "出现问题");
            map.put(
                "- Username has exceeded the 20 character limit",
                "- 用户名超过了 20 个字符的限制"
            );
            map.put(
                "Please reduce the number of characters and try again",
                "请减少字符数并重试"
            );
            map.put(
                "- Password has exceeded the 20 character limit",
                "- 密码超过了 20 个字符的限制"
            );
            map.put(
                "Username has exceeded the 20 character limit",
                "用户名超过了 20 个字符的限制"
            );
            map.put(
                "Password has exceeded the 20 character limit",
                "密码超过了 20 个字符的限制"
            );

            map.put("Total price", "总价");
            map.put("Your Total price", "您的总价");
            // Team 2 Sprint 16
            map.put(
                "View all alternatives / recommendations",
                "查看所有替代产品/推荐产品"
            );

            // Sprint 18- Team3 - Regression for PLP
            map.put("See full availability:", "查看完整供货情况:");
            map.put("Extended attributes:", "更多属性:");
            map.put("Add", "添加");
            map.put(
                "This item has been added to your basket",
                "该物品已添加到您的购物篮"
            );
            map.put("Go To Checkout", "购物结算");
            map.put("Continue Shopping", "继续购物");
            map.put(
                "Are you sure you want to remove all items from your basket?",
                "是否确定要删除购物篮中的所有商品?"
            );
            map.put("Cancel", "取消");
            map.put("Confirm", "确认");
            map.put("Shopping Basket", "购物篮");
            // sprint 19 team 5
            map.put("View All Results", "查看所有結果");
            map.put("BOM Upload", "材料清单上传");
            map.put(
                "Parts List / Bill of Materials (BOM) Upload",
                "部件清单/物料清单 (BOM) 上传"
            );
            map.put("Upload", "上传");

            // Sprint 20 - Team 5
            map.put("My Quotes", "我的报价");
            map.put("Request a Quote", "询价");
            map.put("Request a quote for higher quantities", "申请更多数量的报价");
            map.put(
                "Product may not be an exact match for your search",
                "产品可能与您的搜索条件并不完全匹配"
            );
            // Sprint 20 - team 2
            map.put("Alternatives for", "的替代之选");
            map.put("Compare Selected (0)", "比较选定的物品 (0)");
            map.put("Compare Selected (2)", "比较选定的物品 (2)");
            map.put("Compare Products", "产品比较");
            map.put("Delete All", "全部删除");
            map.put("Back to previous page", "返回上一页");

            // team 5- Sprint 21
            map.put(
                "Due to the length of time since your last login - your online account has been locked for security purposes. To reactivate your account we require you to reset your password - please follow the link below for \"Reset Password\"",
                "出于安全目的，由于长时间未登录，您的在线帐户已锁定。要重新激活您的帐户，请重置密码 - 请点击下面的“重置密码”链接"
            );
            map.put("Reset Password", "重置密码”链接");
            map.put("Order Code:", "库存编号");
            map.put("Operating Temperature Min:", "工作温度最小值:");
            map.put("Operating Temperature Max:", "工作温度最高值:");
            map.put("Capacitance Tolerance:", "电容公差:");
            map.put("Diameter:", "直径:");
            map.put("Lead Spacing:", "引脚节距:");
            map.put("Also Known As:", "not available on china");
            map.put("Lifetime @ Temperature:", "寿命 @ 温度:");
            map.put("Height:", "高度:");
            map.put("ESR:", "等效串联电阻(ESR):");
            map.put("Dielectric Characteristic:", "电介质特征:");
            map.put("Packaging:", "封装:");
            // Team 4
            map.put("Scheduling or Consolidating Orders", "计划或合并订单");
            map.put("Schedule your order", "制定订单计划");
            map.put(
                "Use our scheduling tool to purchase large quantities up front for up to 12 months in advance.",
                "是否要创建计划或合并此订单？"
            );
            map.put("Create Schedule", "创建计划");
            map.put("Create", "创建计划");
            map.put("Order scheduled!", "已做好订单计划！");
            map.put(
                "You have successfully scheduled your order. We will handle all the planning to ensure the delivery schedule is met.",
                "您已成功制定下单计划。我们将处理所有计划，以确保按要求交付。"
            );
            map.put("Review", "审查");
            map.put("No, don't delete the schedule", "否，不删除此计划");
            map.put("Confirm", "确认");
            map.put("Delete schedule", "删除计划");
            map.put(
                "Are you sure you want to delete the schedule you have created for this order?",
                "是否确实要删除为此订单创建的计划？"
            );
            map.put("Log In", "登录");
            map.put(
                "To create an order schedule you need to be logged in. This feature is not available for guest checkout users.",
                "您须登录以创建订单计划。此功能不适用于以访客身份结账的用户。"
            );
            map.put(
                "Would you like to create a schedule or consolidate this order?",
                "是否要创建计划或合并此订单？"
            );
            // sprint 22
            map.put("Images", "图片");
            map.put(
                "image is for illustrative purposes only. Please refer to product description",
                "图片仅用于图解说明，详见产品说明"
            );

            // Team 5- Sprint 22
            map.put(
                "Renminbi account company: Yiluomeng Electronics (China) Co., Ltd.",
                "人民币帐户公司：易络盟电子（中国）有限公司"
            );
            map.put(
                "Bank: China Construction Bank Shanghai Jing'an Branch",
                "银行：中国建设银行上海静安支行"
            );
            map.put(
                "Bank account number: 31001508300050020425",
                "银行帐号： 31001508300050020425"
            );
            map.put("Next Steps:", "您还需要：");
            map.put(
                "please make payment via bank transfer to the below account; please quote the online order number as a reference.",
                "通过银行转账到以下银行账户，并在转账备注填写您的订单号。"
            );

            // Team 2 sprint 22
            map.put("Communities", "社区");
            map.put("View New Products", "查看新产品");
            map.put("View All Manufacturers", "查看所有制造商");

            // sprint 23 - team3

            map.put("Tools", "计算器和换算表");

            // Team 5 - Sprint23
            map.put(
                "When you submit your order, your credit card will be pre-authorized. We will only take payment when your order ships.",
                "您提交订单时，您的信用卡会进行预授权。我们只会在您的订单发货后才收取货款。"
            );

            // sprint 23 - team2
            map.put("Tools_CN", "工具");
            map.put("Add all items to Basket", "将所有商品加入购物篮");
            map.put("Add selected items to Basket", "将选定产品加入购物篮");
            map.put("Line Number", "行号");
            map.put("Manufacturer Part Number", "制造商产品编号");
            map.put("Manufacturer / Description", "制造商 / 说明");
            map.put("Delete Selected", "删除选定商品");
            map.put("Order Code", "库存编号");
            map.put("Re-reel", "Re-reel");
            map.put("Cut Tape", "切割卷带");

            // Team 4-Sprint 24
            map.put("Line Note:", "您的零件号:");
            map.put("Your Part No:", "备注:");
            map.put("Why can't I schedule this item", "Why can't I schedule this item");
            map.put("Re-reel", "Re-reel");
            map.put("Your Basket is Empty", "您的购物篮为空");

            // Team 2-Sprint 25
            map.put(
                "By providing this information you are consenting to receiving emails from the Premier Farnell group, however you may opt out at any time. Privacy",
                "必填区域 请注意，只有在针对您的需求与您联系时，我们才会使用此信息。我们尊重您的隐私权，请查阅我们的 隐私声明"
            );
            map.put("Invalid email address format", "电子邮件地址格式无效");

            // Team 3-Sprint 26
            map.put("View All", "查看");
            // map.put("Order Code:", "库存编号:");

            // DO NOT TOUCH BELOW CODE
            // Team 5-Sprint 26
            //map.put("Account Summary", "我的帐户摘要");
            map.put("Account Summary", "帐户概览");

            // Team 5- Sprint 28
            map.put("My Orders", "我的订单");
            map.put("Order History & Tracking", "订单历史和跟踪");
            map.put("Bill of Materials Upload", "材料清单上传");
            map.put("Request an Invoice Copy", "请求发票副本");
            map.put("Returns", "退货");

            // Team 3 - sprint 28
            map.put("Suggested replacement for 2528848", "2528848 的建议替换值");
            map.put(
                "The Farnell part number 2528848 has changed to YFZVFHTR5.1B",
                "element14 部件号 <0：订购代码> 已更改为 <1：订购代码>"
            );
            map.put(
                "Alternative product for your search. Check specification before ordering.",
                "没有找到您要找的产品。此产品是符合您搜索条件的替代产品，请您在订购前务必确认此产品的规格。"
            );

            // Team 2 - Sprint 28
            map.put("Offers", "特惠甄选");
            map.put("Track Orders", "追踪订单");
            map.put("Favourites", "收藏夹");
            map.put("Min", "最小");
            map.put("Max", "最大");
            map.put("Product Compliance Certificate", "产品合规证书");
            map.put(
                "Download and save a certificate for this product, complete with your unique customer details.",
                "下载和保存此产品的证书，用您的唯一客户详细信息完成此步骤。"
            );
            map.put(
                "Select from either a PDF or printable HTML format.",
                "选择 PDF 或可打印的 HTML 格式。"
            );

            // Team 2 - Sprint 35
            map.put(
                "FREE shipping on orders over $150",
                "订单金额满200元（不含税）免运费"
            );

            // Team 2 - Sprint 36
            map.put("Change Country/Region", "更改国家/地区");

            // Team 2 - sprint 36
            map.put("Order Preferences", "订单首选项");
            map.put("Quotes", "报价");
            map.put("Saved Basket", "保存的购物篮");
            map.put("Profile Information", "资料信息");

            // Team 2- sprint 37
            map.put(
                "Are you sure you want to remove all items from your basket?",
                "是否确定要删除购物篮中的所有商品？"
            );
            map.put("Cancel", "取消");
            map.put("Confirm", "确认");
            map.put("£0.00", "CNY0.00");

            map.put("Login to download CAD Models", " 登录下载 CAD 模型");

            map.put("CAD Downloads", "CAD 下载");
            map.put("--Please select...", "--请选择...");
            map.put("Download", "下载");

            // Team3 - Sprint 38
            map.put("Please enter your values below.", "请输入以下值。");
            map.put("SG stock available for next day delivery", "SG 可第 3-4 日发货");
            map.put("US stock for 4-5 days delivery", "UK 可第 4-5 日发货");
            map.put("UK stock for 3-4 days delivery", "US 可第 4-5 日发货");
            map.put("UK stock available for next day delivery", "UK 可次日发货");
            map.put("SG stock", "SG 可第");
            map.put("UK stock", "UK 可第");
            map.put("US stock", "US 可第");

            // Team 4- sprint 44
            map.put("Payment Method", "支付方式");
            map.put("Invoice and Delivery address", "发票和交货地址");
            map.put("Delivery Options", "选择配送方式");
            map.put("Payment Details", "付款详细信息");

            // Team 4- sprint 46
            map.put("Select All", "全选");
            map.put("Deselect All", "取消全选");
            map.put("Delete 0 selected", "删除已选择的0件产品");
            map.put("Delete Item", "删除产品");

            // team 4 - sprint 39
            map.put(
                "[0-9]+ of [0-9]+ items viewed",
                "查看了 [0-9]+ 个项目中的 [0-9]+ 个"
            );
            map.put("Show More", "装载更多");
            map.put(
                "Please click the checkbox stating that you agree with the Terms of Purchase.",
                "请单击表明您同意“购买条款”的复选框。"
            );

            // Team 4- sprint 40
            map.put("More Pricing", "更多价格");
            map.put("Unit price (including VAT)", "单价（含增值税）");

            // team 2- sprint 40
            map.put("Calculators & Charts", "计算器和换算表");
            map.put("Desktop Site", "电脑网站");
            map.put("Terms of Purchase", "使用条款");
            map.put("Terms of Access", "购买条款");
            map.put("Technical Resources", "技术资源");
            map.put("Qty", "数量");

            // Team 4- sprint 45
            map.put("Order Review", "订单检查");

            // Team 1 sprint 47
            map.put(
                "Due to market conditions delivery times are for general guidance only and may be subject to change at short notice",
                "由于市场条件的影响，交货时间仅供一般指导，可能会在短时间内发生变化"
            );

            // Team 7 Sprint 53
            map.put("Recently Viewed", "最近浏览");

            // Team 4 Sprint 57
            map.put("username", "*用户名");
            map.put("password", "*密码");
            map.put("firstname", "*名");
            map.put("lastname", "* 姓");
            map.put("email address", "*电子邮件地址");
            map.put("phone number", "*电话号码");
            map.put("ext number", "分机号");
            map.put("job role", "*以下哪一条能最好地描述您的工作角色？");
            map.put("primary use", "*您从 ELEMENT14 所购买产品的主要用途是什么？");
            map.put("userName", "用户名");
            map.put("Firstname", "名");
            map.put("Lastname", "姓");
            map.put("Email address", "电子邮件地址");
            map.put("Phone number", "电话号码");
            map.put("Job role", "以下哪一条能最好地描述您的工作角色？");
            map.put("primaryuse", "您从 ELEMENT14 所购买产品的主要用途是什么？");
            map.put("8-20 Characters", "8-20 个字符");
            map.put("Include a lower case letter (a-z)", "一位小写字母（a-z）");
            map.put("Include a uppercase character (A-Z)", "一位大写字母（A-Z）");
            map.put("Include a number (0-9)", "一位数字（0-9）");
            map.put(
                "First Name has exceeded the 43 character limit. Please reduce the number of characters and try again.",
                "名已超过 43 个字符的限制。 请减少字符数量后再试。"
            );
            map.put("Invalid email address format.", "电子邮件地址格式无效。");
            map.put(
                "Please enter a username that has more than 6 characters and less than 20.",
                "请输入长度大于 6 个字符且小于 20 个字符的用户名。"
            );
            map.put(
                "Password entered does not meet password policy requirements. It must be 8-20 characters and contain at least 1 upper case letter, 1 lower case letter, and a number",
                "输入的密码不符合密码设置要求：必须为 8-20 个字符，并且至少包含 1 个大写字母、1 个小写字母和一个数字"
            );
            map.put(
                "Last Name has exceeded the 43 character limit. Please reduce the number of characters and try again.",
                "姓已超过 43 个字符的限制。 请减少字符数量后再试。"
            );

            // Team SSP -sprint 57
            map.put("555 Timer", "555 定时器计算器");
            map.put("555 Timer Calculator.", "555 定时器计算器");
            map.put("/555-timer-calculator", "/555-timer-calculator");
            map.put(
                "The 555 timer is a commonly used integrated circuit that can be configured to produce a square waveform output. In Astable configuration the output will be a free running squarewave output. In Monostable mode the output will be a single high pulse generated for a single input event. This calculator will determine the pulse width of the output based on the resistance and capacitance values entered.",
                "555 定时器是一种常用的集成电路，可以配置为产生方波输出。在非稳态配置中，输出将是一个自由运行的方波输出。在单稳态模式下，输出将是针对单个输入事件产生的单个高脉冲。该计算器将根据输入的电阻值和电容值确定输出的脉冲宽度。"
            );
            map.put("Monostable", "单稳态");
            map.put("Astable", "非稳态");
            map.put("Please enter your values below.", "请在下面输入值。");
            map.put("Resistor (R)", "电阻器 (R)");
            map.put("Capacitance (C)", "电容 (C)");
            map.put("Calculate", "计算");
            map.put("Output Pulse Duration (ms)", "输出脉冲持续时间 (ms)");
            map.put("Formulas", "公式");
            map.put("Diagram View", "图表视图");
            map.put("Resistor (R1)", "电阻器 (R1)");
            map.put("Resistor (R2)", "电阻器 (R2)");
            map.put("Time High (ms)", "时间上限 (ms)");
            map.put("Time Low (ms)", "时间下限 (ms)");
            map.put("Frequency", "频率");
            map.put("Calculator & Conversion Charts Menu", "计算器和换算表菜单");

            //Team 4 Sprint 58
            map.put(
                "Please enter 70 or less characters",
                "密码已超过 70 个字符的限制。 请减少字符数量后再试。"
            );
            map.put(
                "Password entered does not meet the criteria specified below.",
                "输入的密码不符合下面指定的条件"
            );

            // Team SSP -sprint 58
            map.put("Impedance Matching Calculator", "阻抗匹配计算器");
            map.put(
                "Impedance matching allows maximum power transfer between two points.",
                "阻抗匹配允许两点之间的最大功率传输"
            );
            map.put(
                "The impedance matching is a common concept in electronics that helps design a circuit that maximizes the power transfer and/or minimizes signal reflection from the load.",
                "阻抗匹配在电子学中是一个常见的概念，它有助于设计一个使电能传输最大化和/或负载的信号反射最小化的电路。"
            );
            map.put("L Match", "L 型匹配");
            map.put("Pi-Match", "Pi 型匹配");
            map.put("T-Match", "T 型匹配");
            map.put(
                "The L-match impedance matching circuit is used to match the impedance between two points, usually a source and a load.",
                "L 型匹配阻抗匹配电路用于匹配两点（通常是一个源和一个负载）之间的阻抗。"
            );
            map.put("Source Resistance (RS)", "源电阻 (RS)");
            map.put("Source Reactance (XS)", "源电抗 (XS)");
            map.put("Load Resistance (RL)", "负载电阻 (RL)");
            map.put("Load Reactance (XL)", "负载电抗 (XL)");
            map.put("Circuit DC Current", "电路直流电流");
            map.put("Inductance (L)", "电感 (L)");
            map.put("Pass DC Current", "传递直流电流");
            map.put("Block DC Current", "區塊直流電流");
            map.put("Q-Factor", "Q 因子");
            map.put(
                "The Pi match impedance matching circuit is used to match the impedance between two points, usually a source and a load.",
                "Pi 型匹配阻抗匹配电路用于匹配两点（通常是一个源和一个负载）之间的阻抗。"
            );
            map.put("Source Capacitance (CS)", "來源電容 (CS)");
            map.put("Load Capacitance (CL)", "负载电容 (CL)");
            map.put(
                "The T-match impedance matching circuit is used to match the impedance between two points, usually a source and a load.",
                "T 型匹配阻抗匹配电路用于匹配两点（通常是一个源和一个负载）之间的阻抗。"
            );
            map.put("Source Inductance (LS)", "源电感 (LS)");
            map.put("Load Inductance (LL)", "负载电感 (LL)");

            map.put("Transformer Turns Calculator", "变压器匝数计算器");
            map.put(
                "Calculate the primary and secondary full-load currents of the transformer.",
                "计算变压器的初级和次级满负荷电流"
            );
            map.put(
                "This transformer calculator helps you to quickly and easily calculate the primary and secondary full-load currents of the transformer. It also determines the turns ratio and type of transformer.",
                "此变压器计算器可以帮助您快速、轻松地计算变压器的一次和二次满负荷电流。它还决定了变压器的匝数比和类型。"
            );
            map.put("Number of Phases", "相数");
            map.put("Single Phase", "单相");
            map.put("Three Phase", "三相");
            map.put("Transformer Rating", "变压器评级");
            map.put("Primary Transformer Voltage", "主变压器电压");
            map.put("Secondary Transformer Voltage", "辅助变压器电压");
            map.put("Primary Full-Load Current (A)", "一次满负荷电流 (A)");
            map.put("Secondary Full-Load Current (A)", "二次满负荷电流 (A)");
            map.put("Turns Ratio", "匝数比");
            map.put("Transformer Type", "变压器类型");
            map.put("primary", "主要");
            map.put("secondary", "辅助");
            map.put("secondary", "辅助");
            map.put(
                "You can shop the full range of transformers here.",
                "您可以购买各种变压器 这里."
            );

            //HomePagrRegression
            map.put("Popular Manufacturers", "热门制造商");
            map.put("Quick Buy", "快速购买");
            map.put("Parts List (BOM) Upload", "部件列表 (BOM) 上传");
            map.put("Browser Search Tools", "浏览器搜索工具");
            map.put("All Buying Tools", "所有购买工具");
            map.put("Development Boards and Evaluation Kits", "开发板与评估套件");
            map.put("Power and Circuits", "电源与电路");
            map.put("electronics", "机电产品");
            map.put("Tools & Production Supply", "工具与生产用品");
            map.put("D-SUB Connectors and Components", "D-SUB连接器和组件");
            map.put("wire-to-board connector", "线至板连接器");
            map.put("Terminal Blocks & Accessories", "端子块与配件");
            map.put("circular industry and components", "圆形工业和元件");
            map.put("Board-to-Board Connectors", "板至板连接器");
            map.put("Connector Tools and Accessories", "连接器工具和配件");
            map.put("Featured Products", "特色产品");
            map.put("Test and Measurement", "测试与测量");
            map.put("No Longer Manufactured", "不再進貨");
            map.put("Suggested Alternatives", "建议的替代选择");
            map.put("Exact Alternative", "相同替代产品");
            map.put(
                "Sorry, we couldn’t find any products matching",
                "很抱歉，我们找不到与"
            );
            map.put("Search Tips", "搜索提示");
            map.put("Can We Help?", "需要帮助吗？");
            map.put("Popular Product Categories", "最受欢迎的产品类别");
            map.put(
                "You've selected 11 products. You can compare up to 10 products at a time. The most recent 10 products will be shown.",
                "您已选择 11 个产品。您一次最多可比较 10 个产品。将显示最近的 10 个产品。"
            );
            map.put("Successfully saved", "成功保存的购物篮");
            map.put("Price For", "如下物品价格");
            map.put("Price (ex VAT)", "价钱 (不含税)");
            map.put("Refine Results", "细化搜索结果");
            map.put("Login / Register", "登入 / 註冊");
            map.put("New customer?", "新客户？");
            map.put("You have already registered to this site, please log in. If you need help please contact us on contact customer service.", "您已经在本网站注册，请登录。如需帮助，请联系 联系客户服务。");
            map.put("*Required Field", "*必填字段");
            map.put("Email or username", "電子郵件或用戶名");
            map.put("*Password", "*密码");
            map.put("> Contact Us", "> 联系我们");
            map.put("Please enter all required information. The following was not entered:", "请输入全部必填信息。未输入以下信息：");
            map.put("Please correct the following fields:", "请更正以下字段：");
            map.put("Either the email/username or password is incorrect. Please check and re-enter the information again.", "電子郵件/用戶名或密碼不正確。 請檢查並重新輸入信息。");
            map.put("Retrieve Username", "检索用户名");
            map.put("It happens from time to time. We're here to help you.", "这种情况时有发生。我们在此为您提供帮助。");
            map.put("Enter your email and we will recover your username for you.", "输入您的邮箱，我们将为您修复用户名。");
            map.put("* Email", "* 电子邮件地址");
            map.put("If the name and email you entered belongs to a Premier Farnell account, we will recover your username.", "如果您输入的姓名和电子邮件属于 Premier Farnell 帐户，我们将恢复您的用户名。");
            map.put("Please enter a valid Email Address", "请输入有效的电子邮件地址");
            map.put("Forgot your password", "忘记密码了吗");
            map.put("It happens from time to time. We are here to help you.", "它不时发生。我们是来帮助你的。");
            map.put("Enter your email and we'll send you instructions on how to reset your password. Reset links are valid for 24 hours.", "输入您的电子邮件，我们将向您发送有关如何重置密码的说明。重置链接的有效期为 24 小时。");
            map.put("Send Reset Link", "发送重置链接");
            map.put("We found multiple accounts", "我们发现了多个帐户");
            map.put("In order to reset your password please supply the username for which you need to reset", "为了重置您的密码，请提供您需要重置的用户名");
            map.put("Reset email sent", "重置电子邮件已发送");
            map.put("Farnell has sent an email with a link to reset your password to:", "Farnell 已发送一封包含重置密码链接的电子邮件至：");
            map.put("Did not receive the email? Please check that you have a Farnell account, the spelling of the email address and your spam folder.", "没有收到邮件？请检查您是否拥有 Farnell 帐户、电子邮件地址的拼写和垃圾邮件文件夹。");
            map.put("Enter a valid username", "输入有效的用户名");
            map.put("Check your email", "查看你的电子邮件");
            map.put("Email Sent", "邮件已发送");
            map.put("Username has been sent", "用户名已发送");
            map.put("Email Sent", "电子邮件已发送");
            map.put("If you have a registered account with us, you will receive the reset password link to your email.", "如果您是注册用户，您的注册邮箱将收到重置密码链接的邮件");
            map.put("Did not receive the email? Check the spelling of the email address and also your spam folder.", "没有收到电子邮件？请检查电子邮件地址是否正确，同时检查您的垃圾邮件文件夹。");
            map.put("Try to register", "尝试注册");

            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }
            System.out.println("Value of_" + text + "_China=" + value);
        }

        return (value);
    }
}
