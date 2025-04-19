import {
  UilEstate,
  UilClipboardAlt,
  UilUsersAlt,
  UilPackage,
  UilChart,
} from "@iconscout/react-unicons";

export const sidebarData = [
  {
    heading: "系统总览",
    to: "/",
    icon: UilEstate,
  },
  {
    heading: "仓库下单",
    to: "/submit",
    icon: UilClipboardAlt,
  },
  {
    heading: "客户动态",
    to: "/customers",
    icon: UilUsersAlt,
  },
  {
    heading: "订单处理",
    to: "/sales",
    icon: UilPackage,
  },
  {
    heading: "数据分析",
    to: "/analytics",
    icon: UilChart,
  },
];

// ...其他数据和导出
