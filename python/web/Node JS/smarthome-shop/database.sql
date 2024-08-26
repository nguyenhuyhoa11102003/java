-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2024 at 06:35 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smarthome`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

create database smarthome;
use smarthome;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `total_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `total_price`) VALUES
(0, 0),
(1, 390000),
(2, 1790000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `username` varchar(50) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`username`, `cart_id`, `password`, `fullname`, `phone`, `address`) VALUES
('admin', 0, '$2a$10$utEVZWEeGmjZzaWZqv4CI.e73uIF3/LC.b2r2o2iJ/HnP6/3H6.pG', '', '', ''),
('nguyenvana', 1, '$2a$10$u3AL7eyp4gqqy61eH7Yx9eJx0ykz5xW7N.nHkgRdkyCyaO6cV/CoK', 'Nguyễn Văn A', '0909000000', 'Hà Nội'),
('nguyenvanb', 2, '$2a$10$zAcmnqKkM1ist0wZ8r9AIuXgMWJsz8lWUprGZ3wAdcwgaYHAkvbYq', 'Nguyễn Văn B', '0909000111', 'Hà Nội');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `total_price` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id`, `username`, `total_price`, `date`, `status`) VALUES
('17032024000000', 'nguyenvana', 440000, '17/03/2024 00:00:00', 'Chờ xác nhận'),
('17032024111111', 'nguyenvanb', 890000, '17/03/2024 11:11:11', 'Hoàn thành');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `price` int(11) NOT NULL,
  `image` varchar(100) NOT NULL,
  `catalog` varchar(50) NOT NULL,
  `deleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `description`, `price`, `image`, `catalog`, `deleted`) VALUES
(1, 'Đèn LED Downlight Thông Minh', 'Đèn Led âm trần thông minh cho khả năng chiếu sáng ổn định, khả năng chiếu sáng mạnh mẽ, đáp ứng nhu cầu cung cấp ánh sáng hiệu quả. Ngoài ra, đèn còn có tính năng thay đổi cường độ sáng cũng như nhiệt độ màu chiếu sáng theo thời gian. Điều này vừa giúp bảo vệ mắt cho người dùng, vừa đảm bảo tính tương thích cho mỗi khu vực ứng dụng.', 440000, 'led1.png', 'Đèn thông minh', 0),
(2, 'Đèn LED Bulb Thông Minh', 'Thiết kế đèn LED Bulb thông minh với kiểu dáng cơ bản, hội tụ đủ sự tinh tế, sang trọng. Đi cùng với kích thước nhỏ gọn, chỉ 60mmx110mm, sản phẩm đảm bảo được tính đồng bộ cao cho mọi không gian. Với việc lắp đặt thiết bị này ở vị trí phù hợp, tin chắc rằng, không gian sẽ tạo nên được điểm nhấn riêng, nâng tầm đẳng cấp đáng kể cho tổng thể.', 390000, 'led2.png', 'Đèn thông minh', 0),
(3, 'Đèn LED Panel Thông Minh', 'Đèn LED Panel thông minh FPT Smart Home là loại đèn LED chiếu sáng có thiết kế kiểu dáng tròn, vuông hoặc chữ nhật được lắp đặt âm trần hoặc thả trần. Thiết bị đèn thông minh này không chỉ thích hợp chiếu sáng cho không gian gia đình mà còn được lắp đặt tại rất nhiều các công trình công cộng, trường học, bệnh viện, văn phòng,…', 1790000, 'led3.png', 'Đèn thông minh', 0),
(4, 'Cảm Biến Cửa', 'Hiện nay, trong hệ thống an ninh cơ bản tại gia đình, cảm biến cửa thông minh được xem là 1 trong những thiết bị thông minh, cho tính hữu ích cực cao. Trong nhiều phân khúc sản phẩm trên thị trường, model cảm biến cửa đến từ thương hiệu FPT Smart Home đã và đang nhận được sự ưa chuộng và đánh giá cao hơn cả.', 890000, 'cursor1.png', 'Cảm biến', 0),
(5, 'Cảm Biến Chuyển Động', 'Chức năng chính của thiết bị cảm biến chuyển động là phát hiện kịp thời những chuyển động vật lý trong môi trường. Chẳng hạn, khi phát hiện chuyển động bất thường, đặc biệt là dấu hiệu của sự đột nhập trái phép, cảm biến sẽ tự động gửi cảnh báo hay kích hoạt một số chức năng liên quan.', 890000, 'cursor2.png', 'Cảm biến', 0),
(6, 'Cảm Biến Khói', 'Cảm biến khói là thiết bị có khả năng nhận biết, phát hiện nhanh chóng khói hay các đám cháy trong ngôi nhà. Sau đó nó sẽ truyền tín hiệu đến trung tâm điều khiển để gửi báo động và   kích hoạt các thiết bị như còi báo động, vòi phun nước ,... nhằm tạo sự chú ý, sớm ngăn chặn hỏa hoạn xảy ra và giảm thiểu các rủi ro thiệt hại về người và tài sản.', 1240000, 'cursor3.png', 'Cảm biến', 0),
(7, 'Công Tắc Cảm Ứng Athena', 'Công tắc cảm ứng (Touch switch) là loại công tắc chỉ cần chạm nhẹ ngón tay lên mặt kính là có thể bật/ tắt các thiết bị điện trong gia đình. Sản phẩm được sử dụng trong nhiều loại đèn và công tắc tường có vỏ ngoài bằng kim loại cũng như trên các thiết bị đầu cuối máy tính công cộng. Màn hình cảm ứng bao gồm một loạt các công tắc cảm ứng trên màn hình.', 1990000, 'switch1.png', 'Công tắc thông minh', 0),
(8, 'Nút Bấm Ngữ Cảnh Không Dây\n', 'So với các công tắc truyền thống, nút bấm ngữ cảnh không dây với tính tiện ích cao, thuận tiện trong việc sử dụng trở thành lựa chọn đáng cân nhắc hàng đầu cho các không gian hiện đại. Không cần kết nối hay thực hiện tháo lắp phức tạp, với sản phẩm này, bạn vẫn đảm bảo có thể điều khiển, bật tắt các thiết bị chiếu sáng 1 cách nhanh chóng, tiện ích.', 890000, 'switch2.png', 'Công tắc thông minh', 0),
(9, 'Công Tắc Cảm Ứng Hera\n', 'Cũng như người anh em tiền nhiệm, bề mặt công tắc cảm ứng Hera cũng được làm bằng kính cường lực cao cấp, sang trọng, giúp hạn chế bám vân tay, hạn chế trầy xước. Viền kim loại phối bo cạnh, sắc nét, tạo nên vẻ đẹp tinh tế cho từng công tắc. Các cảm ứng nút vuông của công tắc Hera siêu mượt mà, chỉ cần thao tác một lần chạm đã dễ dàng điều khiển trực tiếp. Sử dụng kết nối Zigbee ổn định, có độ bảo mật cao.', 2290000, 'switch3.png', 'Công tắc thông minh', 0),
(10, 'Động Cơ Rèm Thông Minh', 'Động cơ rèm thông minh được cấu tạo với độ hoàn thiện cao, cho phép khả năng lắp đặt, hoạt động ổn định trong hệ thống rèm kéo tự động. Ở động cơ này, phần vỏ của chúng được sản xuất từ chất liệu hợp kim nhôm cao cấp. Chất liệu này vừa đảm bảo được sự chắc chắn cao, cho tính chịu lực tốt, vừa có thể bảo vệ được 1 cách tối ưu các bộ phận bên trong động cơ. Kết cấu từ hợp kim nhôm cũng giúp động cơ cho độ bền bỉ cao theo thời gian.', 3000000, 'curtain1.png', 'Bộ rèm cửa', 0),
(11, 'Bộ Điều Khiển Rèm Cửa Thông Minh', 'Rèm cửa thông minh (Smart Blind) là loại rèm thông minh có khả năng hoạt động tự động nhờ vào một động cơ điện. Khi người dùng tiến hành điều khiển từ xa thông qua ứng dụng hoặc giọng nói thì rèm sẽ tạo ra các tự động các thao tác như mở rèm vào lúc 8h sáng và đóng rèm lúc 8h tối, mở rèm khi bạn trở về nhà, khi trời tối thì rèm tự động đóng lại và bật đèn lên cùng lúc.', 1590000, 'curtain2.png', 'Bộ rèm cửa', 0),
(12, 'Ray Rèm Điện Thông Minh', 'Ray rèm điện sẽ được ứng dụng đồng bộ trong hệ thống rèm cửa tự động. Theo đó, chúng có thể được dùng cho các mô hình rèm tự động trượt ngang hoặc kết cấu rèm bắt trực tiếp lên trần. Có thể lắp đặt, bố trí ray rèm nói chung hay hệ thống rèm tự động nói riêng này tại nhiều không gian khác nhau. Từ khu vực cửa chính ra vào đến các khu cần treo rèm chắn sáng như phòng ngủ, phòng làm việc, phòng đọc sách.', 440000, 'curtain3.png', 'Bộ rèm cửa', 0),
(13, 'Ổ Cắm Thông Minh', 'Ổ cắm thông minh (hay phích cắm thông minh) là loại ổ cắm điện người dùng có thể thực hiện điều khiển thông qua giọng nói các ứng dụng trên smartphone, cho phép sự linh hoạt hơn đáng kể trong quá trình sử dụng, giúp biến mọi thiết bị điện trong nhà bạn trở nên thông minh hơn mà không tốn kém nhiều chi phí.', 450000, 'accessory1.png', 'Phụ kiện', 0),
(14, 'USB ZigBee', 'Hiện nay, nhu cầu sử dụng thiết bị thông minh tại các gia đình đang tăng lên nhanh chóng. Không chỉ 1 mà mỗi gia đình có thể linh hoạt sử dụng nhiều sản phẩm khác nhau để tối ưu hóa nhu cầu của bản thân, mang đến tính tiện ích hơn cho sinh hoạt thường ngày. Để theo dõi cũng như kiểm soát các thiết bị nói trên 1 cách đồng bộ, từ đó, nhận và phát đường truyền đến bộ điều khiển trung tâm nhanh chóng, USB ZigBee là sản phẩm được lựa chọn và ứng dụng lúc này.', 390000, 'accessory2.png', 'Phụ kiện', 0),
(15, 'Bộ Điều Khiển Hồng Ngoại', 'Bộ điều khiển hồng ngoại được trang bị các mắt hồng ngoại có chức năng phát tín hiệu tương ứng với bộ mã nhận diện của các thiết bị sử dụng sóng hồng ngoại trong gia đình để điều khiển các tính năng tương ứng thay thế cho remote.', 690000, 'accessory3.png', 'Phụ kiện', 0),
(16, 'Khoá Cửa Vân Tay Yale', 'Khóa cửa vân tay Yale có thiết kế đa dạng kiểu dáng phù hợp với nhiều phong cách nội thất khác nhau, cho dù là phong cách hiện đại hay phong cách cổ điển thì bạn đều có thể lựa chọn được loại khóa thích hợp. Ngoài ra, thiết kế của các sản phẩm khóa vân tay Yale còn có thể ứng dụng cho cửa chính của nhà, có thể lắp được trên các chất liệu gỗ, cửa sắt,.. với yêu cầu độ dày cửa 35 – 80 mm.', 15090000, 'other1.png', 'Khác', 0),
(17, 'Khoá Cửa Thẻ Từ Yale', 'Khóa cửa thẻ từ Yale là loại khóa thuộc dòng khóa điện tử cao cấp của tập đoàn Assa Abloy, tại Mỹ. Đây cũng là dòng sản phẩm được tích hợp các công nghệ hiện đại với tính năng bảo mật hàng đầu thế giới. Với sản phẩm này, người dùng sẽ dùng thẻ từ để mở khóa. Trên thân khóa cửa sẽ có cảm biến nhận diện thẻ để đọc dữ liệu thẻ đã đăng ký chính chủ. Mỗi thẻ sẽ có một dữ liệu riêng biệt như số chứng minh thư của mỗi người.', 11090000, 'other2.png', 'Khác', 0),
(18, 'Camera SE FPT', 'Thiết bị an ninh này được tích hợp tính năng kết nối wifi tiện ích. Như vậy, ngay khi lắp đặt trong trường hợp không thể đi được dây mạng hoặc không có nhu cầu đi đường dây mạng cố định, người dùng hoàn toàn có thể kết nối camera trong nhà qua wifi.  Lúc này, thiết bị vừa đảm bảo hoạt động với hiệu suất cao nhất, lại vừa nâng cao sự linh hoạt, đảm bảo tính thẩm mỹ cho không gian bố trí camera.', 830000, 'other3.png', 'Khác', 0);

-- --------------------------------------------------------

--
-- Table structure for table `productcart`
--

CREATE TABLE `productcart` (
  `product_id` int(11) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productcart`
--

INSERT INTO `productcart` (`product_id`, `cart_id`, `quantity`) VALUES
(2, 1, 1),
(3, 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`username`),
  ADD KEY `cart_id` (`cart_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `productcart`
--
ALTER TABLE `productcart`
  ADD PRIMARY KEY (`product_id`,`cart_id`) USING BTREE,
  ADD KEY `cart_id` (`cart_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`username`) REFERENCES `customer` (`username`);

--
-- Constraints for table `productcart`
--
ALTER TABLE `productcart`
  ADD CONSTRAINT `productcart_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `productcart_ibfk_2` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;