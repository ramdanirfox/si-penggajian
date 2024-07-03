-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2024 at 02:19 PM
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
('1', '1', 'Menjenguk Kakek di Rumah', '2024-07-10', '2024-07-11');

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
(3, 'Dewi', '1990-07-21', 'P', 'Sukabumi', '083877445960', 'Manager', 'II', 'dewi', 'dewi'),
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
('7', '2024-06-04 00:55:00.000000', '2024-06-04 09:59:00.000000'),
('7', '2024-06-05 01:03:00.000000', '2024-06-05 09:58:00.000000'),
('7', '2024-06-06 01:05:00.000000', '2024-06-06 10:00:00.000000'),
('7', '2024-06-07 01:07:00.000000', '2024-06-07 10:01:00.000000'),
('7', '2024-06-10 00:55:01.000000', '2024-06-10 10:04:00.000000'),
('7', '2024-06-11 00:55:00.000000', '2024-06-11 09:59:00.000000'),
('7', '2024-06-12 01:04:00.000000', '2024-06-12 09:58:00.000000'),
('7', '2024-06-13 01:05:00.000000', '2024-06-13 10:00:00.000000'),
('7', '2024-06-14 01:03:00.000000', '2024-06-14 10:00:00.000000'),
('7', '2024-06-19 01:00:01.000000', '2024-06-19 10:00:00.000000'),
('7', '2024-06-20 00:55:00.000000', '2024-06-20 09:59:00.000000'),
('7', '2024-06-21 01:04:00.000000', '2024-06-21 09:58:00.000000'),
('7', '2024-06-24 01:00:01.000000', '2024-06-24 10:10:00.000000'),
('7', '2024-06-25 00:55:00.000000', '2024-06-25 10:03:00.000000'),
('7', '2024-06-26 01:04:00.000000', '2024-06-26 10:02:00.000000'),
('7', '2024-06-27 01:05:00.000000', '2024-06-27 10:05:00.000000'),
('7', '2024-06-28 01:13:00.000000', '2024-06-28 10:20:00.000000');

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
(9, 'Dito', 'Manager', 'IV', 10, 10000, 100000, 4, '2024-05-08'),
(11, 'Fachri', 'Staff IT', 'I', 2, 40000, 80000, 7, '2024-07-02'),
(12, 'Fachri', 'Staff IT', 'I', 10, 40000, 400000, 7, '2024-07-04');

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
(2, '2017-06-10', 'Muhammad Ali', 'Kepala HRD', 'I', 4000000, 120000, 200000, 50000, 4270000),
(3, '2023-05-05', 'Nita', 'Sekertaris', 'I', 10000000, 45000, 500000, 2500000, 8045000);

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
('P-0001', '4', 'Iuran', '2024-07-18', 10000);

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
('T-0001', '4', 'Transport', '2024-06-11', 9500),
('T-0002', '4', 'Transport', '2024-05-08', 8700),
('T-0003', '4', 'Makan', '2024-05-07', 5600);

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
  MODIFY `lemburID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `penggajian`
--
ALTER TABLE `penggajian`
  MODIFY `gajiID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `noID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
