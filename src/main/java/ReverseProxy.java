/**
 * 反向代理
 *
 *     server {
 *         listen       8080;       //监听的端口号
 *         server_name  localhost;  //监听的服务域名
 *
 *         location / {     //可以正则表达式
 *                          //1、~   表示将要匹配一个正则，区分大小写
 *                          //2、~*  表示将要匹配一个正则，不区分大小写
 *                          //3、^~  对uri 起始字符 做 字符串匹配，不是正则匹配。 区分大小写
 *                          //4、=   进行普通字符精确匹配
 *                          //5、!~  区分大小写不匹配 (正则)
 *                          //6、!~* 不区分大小写不匹配 (正则)
 *                          //7、不带符号 匹配起始于此字符串的所有uri，区分大小写，字符串匹配
 *
 *
 *             rewrite      ^/mobile/(.*) $1 break;  //rewrite regex replacement [flag];
 *                                                   //1、$1表示替换掉第一个参数，也就是替换 (.*)
 *                                                   //2、[flag]:
 *                                                              2.1 last         表示完成rewrite,
 *                                                              2.2 break        中止rewirte，不在继续匹配
 *                                                              2.3 redirect     返回302临时重定向，地址栏会显示跳转后的地址
 *                                                              2.4 permanent    返回301永久重定向，地址栏会显示跳转后的地址
 *
 *             proxy_pass  127.0.0.1:7001/remote;      //设置被代理server的协议和地址
 *                                                     //1、地址可以为域名或IP
 *                                                     //2、在proxy_pass前面用了rewrite
 *                                                     //3、如果url包括uri，则request中的uri部分会被proxy_pass中的uri取代
 *                                                          比如request http://example.com/name/test.html 会被代理到 http://example.com/remote/test.html
 *                                                     //4、如果url不包括uri,uri会保持原样传送给后端server
 *                                                          比如
 *                                                     //5、当在后面的url加上了/，相当于是绝对路径，如果没有/，表示相对路径，把匹配的路径部分也给代理走。
 *
 *
 *             if($invalid_referer){                    //if (condition){...}
 *                  rewrite ^/ http://$host/logo.png;   //1、直接比较变量和内容时，使用=或!=
 *                                                      //2、~  正则表达式匹配
 *                                                      //3、~* 不区分大小写的匹配
 *                                                      //4、!~  区分大小写的不匹配
 *                                                      //5、-f和!-f  用来判断是否存在文件
 *                                                      //6、下面是可以用作if判断的全局变量
 *                                                            6.1 $args ： #这个变量等于请求行中的参数，同$query_string
 *                                                            6.2 $host ： 请求主机头字段，否则为服务器名称。
 *                                                            6.3 $http_cookie ： 客户端cookie信息
 *                                                            6.4 $request_method ： 客户端请求的动作，通常为GET或POST
 *                                                            6.5 $request_uri ： 包含请求参数的原始URI，不包含主机名，如：”/foo/bar.php?arg=baz”
 *                                                            6.6 $uri ： 不带请求参数的当前URI，$uri不包含主机名，如”/foo/bar.html”。
 *             }
 *         }
 *     }
 *
 *
 * }
 */
public class ReverseProxy {
}


