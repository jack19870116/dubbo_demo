//package com.tiancaibao.controller.shop;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.tiancaibao.service.interfaces.shop.IShopService;
//import com.tiancaibao.service.interfaces.user.IUserService;
///**
// * 商城相关的部分
// * @author THINK
// * 2017-05-26
// */
//@Controller
//@RequestMapping("/shop")
//public class ShopController {
//	@Autowired
//	private IUserService userService;
//	@Autowired
//	private IShopService shopService;
//	
////	 public function __construct()
////	    {
////	        $token = \Request::json('token');
////	        if (!empty($token)) {
////	            $this->user = User::where('remember_token', $token)->select('id', 'integral', 'phone', 'trading_password', 'idcard_number')->first(); //where('id',416)->first();//
////	            if(empty($this->user)){
////	                $this->integral = 0;
////	                $this->use_integral = 0;
////	            }else {
////	                $this->integral = $this->user->integral;
////	                $this->use_integral = abs(IntegralRecord::where('user_id', $this->user->id)->where('integral', '<', 0)->sum('integral'));
////	            }
////	        } else {
////	            $this->user = array();
////	            $this->integral = 0;
////	            $this->use_integral = 0;
////	        }
////
////	        $this->appId = env('WECHAT_APP_ID');
////	        $this->secret = env('WECHAT_APP_SECRET');
////	    }
//	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//	 //商品列表(首页)
////    public function postShopIndex(Request $request)
////    {
////        $shopTypes = ShopType::orderBy('sorder', 'asc')
////            ->select('id', 'name')
////            ->where('class_id', 0)
////            ->get();
////
////        if (empty($shopTypes)) {
////            return response()->json(
////                [
////                    'success' => true,
////                    'error' => '暂无商品信息',
////                    'data' =>
////                        [
////                        ],
////                    'integral' => $this->integral,
////                    'use_integral' => $this->use_integral,
////                    'recommend_shop' => '',
////                    'userinfo' => $this->user,
////                ]
////            );
////        }
////
////        //商城活动
////        $shop_activity = ShopActivity::select('id', 'name', 'url')
////            ->orderBy('order', 'asc')
////            ->orderBy('created_at', 'desc')
////            ->where('is_close', 1)
////            ->where('order', '<=', 4)
////            ->take(4)
////            ->get();
////
////        foreach ($shopTypes as $key => $shopType) {
////            $data[$key]['type_id'] = $shopType['id'];
////            $data[$key]['name'] = $shopType['name'];
////
////            switch ($shopType['id']) {
////                case 1:  //卡券(投资券)
////                    $data[$key]['shops'] = AddInterestCashCoupon::where('shop_class_id', $shopType['id'])
////                        ->where('sisshop', 1)
////                        ->orderBy('created_at', 'desc')
////                        ->orderBy('sorder', 'asc')
////                        ->select('id', 'value', 'condition', 'limit_time', 'days', 'type', 'sprice', 'shop_num')
////                        ->orderBy('value', 'asc')
////                        ->take(6)
////                        ->get();
////                    break;
//////                case 2:  //电子礼券区
//////                    $data[$key]['type'] = 'eepw_ticket';
//////                    $data[$key]['shops'] = Shop::where('shop_class_id', $shopType['id'])
//////                        ->where('sisshop', 1)
//////                        ->orderBy('created_at', 'desc')
//////                        ->orderBy('sorder', 'asc')
//////                        ->select('id', 'name', 'sprice', 'shop_num', 'spic')
//////                        ->take(6)
//////                        ->get();
//////                    break;
////                default: //其他商品
////                    $data[$key]['child_class'] = ShopType::select('id', 'name')
////                        ->where('class_id', $shopType['id'])
////                        ->orderBy('updated_at', 'asc')
////                        //->take(3)
////                        ->get();
////                    $data[$key]['shops'] = Shop::where('shop_class_id', $shopType['id'])
////                        ->where('sisshop', 1)
////                        ->where('is_recommend', 0)
////                        ->orderBy('created_at', 'desc')
////                        ->orderBy('sorder', 'asc')
////                        ->select('id', 'name', 'sprice', 'shop_num', 'spic')
////                        ->take(6)
////                        ->get();
////                    break;
////            }
////        }
////
////        //商品推荐
////        $recommend_shop = Shop::where('is_recommend', 1)
////            ->where('sisshop', 1)
////            ->orderBy('created_at', 'desc')
////            ->orderBy('sorder', 'asc')
////            ->select('id', 'shop_class_id', 'name', 'sprice', 'shop_num', 'spic')
////            ->take(4)
////            ->get();
////
////        return response()->json(
////            [
////                'success' => true,
////                'error' => '',
////                'data' => $data,
////                'integral' => $this->integral,
////                'use_integral' => $this->use_integral,
////                'recommend_shop' => $recommend_shop,
////                'shop_activity' => $shop_activity,
////                'phone' => !empty($this->user->phone)?$this->user->phone:'',
////                'userinfo' => $this->user,
////            ]
////        );
////    }
//	/**
//	 * 商城首頁商品列表（首页）
//	 * @param token
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value="/shop-index",method=RequestMethod.POST)
//	public @ResponseBody String shopIndex(String token){
//	
//		return shopService.goToShopIndex(token);
//	}
//
////	 //分类更多展示
////    public function postShopMore(Request $request)
////    {
////        $type_id = $request->json('type_id') ? $request->json('type_id') : 0;
////        if ($type_id == 0) {
////            return response()->json(
////                [
////                    'success' => true,
////                    'error' => '客官,小序没有接受到正确的请求!',
////                    'data' => array(),
////                    'type_id' => $type_id,
////                    'integral' => $this->integral,
////                    'use_integral' => $this->use_integral,
////                    'shop_type' => '',
////                ]
////            );
////        }
////
////        $shop_type = ShopType::where('id', $type_id)->select('id', 'class_id', 'name')->first();
////        if(empty($shop_type)){
////            return response()->json(
////                [
////                    'success' => true,
////                    'error' => '客官,小序没有接受到正确的请求!',
////                    'data' => array(),
////                    'type_id' => $type_id,
////                    'integral' => $this->integral,
////                    'use_integral' => $this->use_integral,
////                    'shop_type' => '',
////                ]
////            );
////        }
////        if ($shop_type->class_id != 0) {
////            $shop_type_data = ShopType::where('id', $shop_type->class_id)->select('id', 'class_id', 'name')->first();
////            $shop_type_data['child_shop_type'] = ShopType::where('class_id', $shop_type->class_id)->select('id', 'class_id', 'name')->get();
////            $shop_type_data['type'] = 1;    //子类
////        } else {
////            $shop_type_data = $shop_type;
////            $shop_type_data['child_shop_type'] = ShopType::where('class_id', $shop_type->id)->select('id', 'class_id', 'name')->get();
////            $shop_type_data['type'] = 2;    //父类
////        }
////
////        $pageindex = $request->json('pageIndex') ? $request->json('pageIndex') : 0;
////        $pagesize = $request->json('pageSize') ? $request->json('pageSize') : 12;
////
////        switch ($type_id) {
////            case 1:
////                $data = AddInterestCashCoupon::where('shop_class_id', $type_id)
////                    ->where('sisshop', 1)
////                    ->orderBy('created_at', 'desc')
////                    ->orderBy('sorder', 'asc')
////                    ->orderBy('value', 'asc')
////                    ->select('id', 'name', 'value', 'condition', 'limit_time', 'days', 'type', 'sprice', 'shop_num')
////                    ->paginate($pagesize, [], '', $pageindex)
////                    ->toArray();
////                break;
////            default:
////                if ($shop_type_data['type'] == 2) {
////                    $shop_data = Shop::where('shop_class_id', $shop_type_data['id']);                 //父类ID
////                } else {
////                    $shop_data = Shop::where('shop_class_id', $shop_type_data['id'])//父类ID
////                    ->where('child_class_id', $type_id);              //子类ID
////                }
////                $data = $shop_data->where('sisshop', 1)
////                    ->orderBy('created_at', 'desc')
////                    ->orderBy('sorder', 'asc')
////                    ->select('id', 'name', 'sprice', 'shop_num', 'spic')
////                    ->paginate($pagesize, [], '', $pageindex)
////                    ->toArray();
////                break;
////        }
////
////        if (empty($data)) {
////            return response()->json(
////                [
////                    'success' => true,
////                    'error' => '暂无媒体信息',
////                    'data' => '',
////                    'type_id' => $type_id,
////                    'integral' => $this->integral,
////                    'use_integral' => $this->use_integral,
////                    'shop_type' => $shop_type_data,
////                ]
////            );
////        }
////        return response()->json(
////            [
////                'success' => true,
////                'error' => '',
////                'type_id' => $type_id,
////                'data' => $data,
////                'integral' => $this->integral,
////                'use_integral' => $this->use_integral,
////                'shop_type' => $shop_type_data,
////            ]
////        );
////    }
//	
//	/**
//	 * 更多商品的展示
//	 * @param token
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value="/",method=RequestMethod.POST)
//	public @ResponseBody String postShopMore(String token,HttpServletRequest request){
//		return shopService.getShopMore(token);
//	}
//	
//	
//}
