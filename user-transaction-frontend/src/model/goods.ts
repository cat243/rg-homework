/**
 * 商品类别
 */
export type GoodsType = {
    id: number;
    goodsTitle:string;
    description:string;
    images:string;
    tags:string;
    prices:number;
    sellerId:number;
    num:number;
    createTime:Date;
    updateTime:Date;
};