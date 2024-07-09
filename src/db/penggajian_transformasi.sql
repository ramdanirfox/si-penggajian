-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2024 at 01:32 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penggajian`
--

-- --------------------------------------------------------

--
-- Table structure for table `cuti`
--

CREATE TABLE `cuti` (
  `cutiID` varchar(20) NOT NULL,
  `karyawanID` varchar(50) NOT NULL,
  `alasan` varchar(255) NOT NULL,
  `tgl_cuti` date NOT NULL,
  `tgl_masuk` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cuti`
--

INSERT INTO `cuti` (`cutiID`, `karyawanID`, `alasan`, `tgl_cuti`, `tgl_masuk`) VALUES
('C-0003', '8', 'Mudik Lebaran Idul Fitri', '2024-04-08', '2024-04-09'),
('C-0004', '7', 'Pulang Kampung Lebaran', '2024-04-12', '2024-04-15'),
('C-0005', '3', 'Cuti Melahirkan', '2024-05-13', '2024-05-17'),
('C-0006', '8', 'Perpanjang SIM Motor', '2024-11-27', '2024-11-29'),
('C-0007', '7', 'Perpanjang STNK', '2024-12-04', '2024-12-09'),
('C-0008', '9', 'Pernikahan Saudara', '2024-07-05', '2024-07-08'),
('C-0009', '7', 'Pernikahan Saudara', '2024-06-04', '2024-06-05'),
('C-0010', '3', 'Acara Ulang Tahun Anak', '2024-04-01', '2024-04-02'),
('C-0011', '2', 'Acara Pembagian Raport', '2024-09-11', '2024-09-12'),
('C-0012', '7', 'Acara Keluarga', '2024-06-27', '2024-07-01'),
('C-0013', '7', 'Janji Dokter', '2024-09-10', '2024-09-11'),
('C-0014', '7', 'Cuti Idul Adha', '2024-06-17', '2024-06-19');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `karyawanID` int(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jk` varchar(15) NOT NULL,
  `alamat` text NOT NULL,
  `noHP` varchar(12) DEFAULT NULL,
  `jabatan` varchar(15) NOT NULL,
  `golongan` varchar(3) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`karyawanID`, `nama`, `tgl_lahir`, `jk`, `alamat`, `noHP`, `jabatan`, `golongan`, `username`, `password`) VALUES
(1, 'Theo', '1976-08-10', 'L', 'Cikarang', '081290989873', 'Direktur', 'I', 'theo', 'theo'),
(2, 'Vandi', '1983-09-07', 'L', 'Bandung', '081297917821', 'Manager', 'I', 'vandi', 'vandi'),
(3, 'Shanti Dewi', '1990-07-21', 'P', 'Sukabumi', '083877445960', 'Manager', 'II', 'dewi', 'dewi'),
(4, 'Ikhsan', '1987-06-10', 'L', 'Bekasi', '083876571892', 'Manager', 'III', 'ikhsan', 'ikhsan'),
(5, 'Teuku Naufal', '1989-06-17', 'L', 'Kuningan', '081291918374', 'Sales', 'IV', 'teuku', 'teuku'),
(6, 'Trya', '1995-09-19', 'P', 'Jakarta Utara', '081282827455', 'Admin', 'II', 'trya', 'trya'),
(7, 'Fachri', '1993-03-23', 'L', 'Pasar Baru', '085695308403', 'Staff IT', 'I', 'fachri', 'fachri'),
(8, 'Mulyadi', '1990-05-10', 'L', 'Margonda', '085719079629', 'Staff IT', 'II', 'mulyadi', 'mulyadi'),
(9, 'Yayat', '1990-05-16', 'L', 'Jakarta Timur	', '081314752325', 'Karyawan', 'I', 'yayat', 'yayat');

-- --------------------------------------------------------

--
-- Table structure for table `kehadiran`
--

CREATE TABLE `kehadiran` (
  `karyawanID` varchar(50) NOT NULL,
  `jam_masuk` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `jam_pulang` timestamp(6) NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kehadiran`
--

INSERT INTO `kehadiran` (`karyawanID`, `jam_masuk`, `jam_pulang`) VALUES
('5', '2024-06-30 08:18:00.000000', '2024-06-30 10:30:00.000000'),
('5', '2024-06-30 09:01:00.000000', '2024-06-30 10:00:00.000000'),
('4', '2024-07-01 00:00:00.000000', '2024-07-01 02:11:00.000000'),
('7', '2024-06-03 00:59:01.000000', '2024-06-03 10:10:00.000000'),
('7', '2024-06-05 01:03:00.000000', '2024-06-05 09:58:00.000000'),
('7', '2024-06-06 01:05:00.000000', '2024-06-06 10:00:00.000000'),
('7', '2024-06-07 01:03:00.000000', '2024-06-07 16:51:40.000000'),
('7', '2024-06-10 00:55:01.000000', '2024-06-10 10:04:00.000000'),
('7', '2024-06-11 00:55:00.000000', '2024-06-11 09:59:00.000000'),
('7', '2024-06-12 01:04:00.000000', '2024-06-12 09:58:00.000000'),
('7', '2024-06-13 01:05:00.000000', '2024-06-13 10:00:00.000000'),
('7', '2024-06-14 01:03:00.000000', '2024-06-14 10:00:00.000000'),
('7', '2024-06-19 01:00:01.000000', '2024-06-19 10:00:01.000000'),
('7', '2024-06-20 00:55:00.000000', '2024-06-20 09:59:00.000000'),
('7', '2024-06-21 01:03:00.000000', '2024-06-21 13:58:00.000000'),
('7', '2024-06-24 01:00:01.000000', '2024-06-24 10:10:00.000000'),
('7', '2024-06-25 00:55:00.000000', '2024-06-25 10:03:00.000000'),
('7', '2024-06-26 01:04:00.000000', '2024-06-26 10:02:00.000000'),
('8', '2024-05-02 01:03:00.000000', '2024-05-04 09:58:00.000000'),
('8', '2024-05-03 01:05:00.000000', '2024-05-05 10:00:00.000000'),
('8', '2024-05-06 01:03:00.000000', '2024-05-08 16:51:00.000000'),
('8', '2024-05-07 00:55:00.000000', '2024-05-11 10:04:00.000000'),
('8', '2024-05-08 00:55:00.000000', '2024-05-12 09:59:00.000000'),
('8', '2024-05-10 01:04:00.000000', '2024-05-15 09:58:00.000000'),
('8', '2024-05-13 01:05:00.000000', '2024-05-16 10:05:00.000000'),
('8', '2024-05-14 01:03:00.000000', '2024-05-17 10:03:00.000000'),
('8', '2024-05-15 01:05:00.000000', '2024-05-18 10:04:00.000000'),
('8', '2024-05-16 01:03:00.000000', '2024-05-19 10:00:00.000000'),
('8', '2024-05-17 01:02:00.000000', '2024-05-22 10:01:00.000000'),
('8', '2024-05-20 01:02:00.000000', '2024-05-20 10:02:00.000000'),
('8', '2024-05-21 01:00:00.000000', '2024-05-21 10:00:00.000000'),
('8', '2024-05-22 01:01:00.000000', '2024-05-22 10:02:00.000000'),
('8', '2024-05-24 01:04:00.000000', '2024-05-25 09:58:00.000000'),
('8', '2024-05-26 01:10:00.000000', '2024-05-26 09:59:00.000000'),
('8', '2024-05-28 01:03:00.000000', '2024-05-28 09:58:00.000000'),
('8', '2024-05-27 01:05:00.000000', '2024-05-27 15:02:00.000000'),
('8', '2024-04-30 01:03:00.000000', '2024-04-30 10:08:00.000000'),
('8', '2024-04-29 01:05:00.000000', '2024-04-29 09:55:00.000000'),
('7', '2024-05-30 00:40:00.000000', NULL),
('7', '2024-05-29 01:05:00.000000', '2024-05-29 10:03:00.000000'),
('7', '2024-05-31 01:01:00.000000', '2024-05-31 07:55:00.000000'),
('7', '2024-07-09 22:40:28.693734', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lembur`
--

CREATE TABLE `lembur` (
  `lemburID` int(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jabatan` varchar(15) NOT NULL,
  `golongan` varchar(3) NOT NULL,
  `jml_jam` int(3) NOT NULL,
  `gaji_perjam` int(10) NOT NULL,
  `total` int(10) NOT NULL,
  `karyawanID` int(11) NOT NULL,
  `tanggal_lembur` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `lembur`
--

INSERT INTO `lembur` (`lemburID`, `nama`, `jabatan`, `golongan`, `jml_jam`, `gaji_perjam`, `total`, `karyawanID`, `tanggal_lembur`) VALUES
(11, 'Fachri', 'Staff IT', 'I', 7, 40000, 280000, 7, '2024-06-07'),
(12, 'Fachri', 'Staff IT', 'I', 4, 40000, 160000, 7, '2024-06-21'),
(14, 'Mulyadi', 'Staff IT', 'II', 5, 40000, 200000, 8, '2024-07-10'),
(15, 'Yayat', 'Karyawan', 'I', 5, 40000, 200000, 9, '2024-07-10'),
(16, 'Mulyadi', 'Staff IT', 'II', 4, 40000, 160000, 8, '2024-07-14'),
(18, 'Fachri', 'Staff IT', 'I', 6, 40000, 240000, 7, '2024-05-14'),
(19, 'Fachri', 'Staff IT', 'I', 4, 40000, 160000, 7, '2024-03-18'),
(20, 'Fachri', 'Staff IT', 'I', 7, 40000, 280000, 7, '2024-03-08'),
(21, 'Mulyadi', 'Staff IT', 'II', 5, 40000, 200000, 8, '2024-05-27'),
(23, 'Ikhsan', 'Manager', 'III', 5, 40000, 200000, 4, '2024-05-21');

-- --------------------------------------------------------

--
-- Table structure for table `penggajian`
--

CREATE TABLE `penggajian` (
  `gajiID` int(5) NOT NULL,
  `tgl` date NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jabatan` varchar(15) NOT NULL,
  `golongan` varchar(3) NOT NULL,
  `gapok` int(10) NOT NULL,
  `gaji_lembur` int(10) NOT NULL,
  `tunjangan` int(10) NOT NULL,
  `potongan` int(10) NOT NULL,
  `gaji_bersih` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `penggajian`
--

INSERT INTO `penggajian` (`gajiID`, `tgl`, `nama`, `jabatan`, `golongan`, `gapok`, `gaji_lembur`, `tunjangan`, `potongan`, `gaji_bersih`) VALUES
(4, '2024-06-28', 'Fachri', 'Staff IT', 'I', 5000000, 440000, 650000, 210000, 5880000),
(6, '2024-05-28', 'Mulyadi', 'Staff IT', 'II', 5500000, 200000, 135000, 85000, 5750000),
(7, '2024-05-28', 'Vandi', 'Manager', 'I', 8000000, 0, 580000, 385000, 8195000),
(8, '2024-05-28', 'Shanti Dewi', 'Manager', 'II', 7000000, 0, 200000, 320000, 6880000),
(9, '2024-05-28', 'Ikhsan', 'Manager', 'III', 7000000, 200000, 350000, 300000, 7250000);

-- --------------------------------------------------------

--
-- Table structure for table `potongan`
--

CREATE TABLE `potongan` (
  `potonganID` varchar(50) NOT NULL,
  `karyawanID` varchar(50) NOT NULL,
  `jenis_potongan` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlah` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `potongan`
--

INSERT INTO `potongan` (`potonganID`, `karyawanID`, `jenis_potongan`, `tanggal`, `jumlah`) VALUES
('P-0001', '4', 'Iuran', '2024-07-18', 10000),
('P-0002', '7', 'Pajak', '2024-06-28', 150000),
('P-0003', '7', 'Iuran', '2024-06-28', 60000),
('P-0004', '7', 'Iuran', '2024-05-28', 60000),
('P-0005', '2', 'Iuran', '2024-06-28', 135000),
('P-0006', '8', 'Iuran', '2024-05-28', 85000),
('P-0007', '2', 'Pajak', '2024-05-28', 385000),
('P-0008', '3', 'Pajak', '2024-05-28', 320000),
('P-0009', '4', 'Pajak', '2024-05-28', 300000);

-- --------------------------------------------------------

--
-- Table structure for table `tunjangan`
--

CREATE TABLE `tunjangan` (
  `tunjanganID` varchar(50) NOT NULL,
  `karyawanID` varchar(50) NOT NULL,
  `jenis_tunjangan` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlah` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tunjangan`
--

INSERT INTO `tunjangan` (`tunjanganID`, `karyawanID`, `jenis_tunjangan`, `tanggal`, `jumlah`) VALUES
('T-0001', '4', 'Transport', '2024-06-11', 200000),
('T-0002', '4', 'Transport', '2024-05-08', 150000),
('T-0003', '4', 'Makan', '2024-05-07', 200000),
('T-0004', '7', 'Makan', '2024-06-07', 200000),
('T-0005', '7', 'Makan', '2024-06-14', 200000),
('T-0006', '7', 'Transport', '2024-06-21', 200000),
('T-0007', '7', 'Transport', '2024-06-26', 50000),
('T-0008', '7', 'Reimburse', '2024-05-28', 135000),
('T-0009', '8', 'Transport', '2024-05-20', 135000),
('T-0010', '2', 'Reimburse', '2024-05-20', 580000),
('T-0011', '3', 'Makan', '2024-05-20', 200000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `noID` int(3) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`noID`, `username`, `password`) VALUES
(2, 'admin', 'admin'),
(4, 'dito', 'dito'),
(5, 'akira', 'akira');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`karyawanID`);

--
-- Indexes for table `lembur`
--
ALTER TABLE `lembur`
  ADD PRIMARY KEY (`lemburID`);

--
-- Indexes for table `penggajian`
--
ALTER TABLE `penggajian`
  ADD PRIMARY KEY (`gajiID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`noID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `karyawanID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `lembur`
--
ALTER TABLE `lembur`
  MODIFY `lemburID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `penggajian`
--
ALTER TABLE `penggajian`
  MODIFY `gajiID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `noID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
