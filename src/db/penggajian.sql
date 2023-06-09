-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2023 at 07:43 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `golongan` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`karyawanID`, `nama`, `tgl_lahir`, `jk`, `alamat`, `noHP`, `jabatan`, `golongan`) VALUES
(1, 'Muhammad Ali', '1997-02-03', 'L', 'Depok', '0909098987', 'Kepala HRD', 'I'),
(2, 'Nita', '1992-06-06', 'P', 'Bandung', '9898786760', 'Sekertaris', 'I'),
(3, 'Andi', '1992-08-21', 'L', 'Tegal', '9890807089', 'Staff IT', 'I');

-- --------------------------------------------------------

--
-- Table structure for table `kehadiran`
--

CREATE TABLE `kehadiran` (
  `karyawanID` varchar(50) NOT NULL,
  `jam_masuk` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `jam_pulang` timestamp(6) NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lembur`
--

INSERT INTO `lembur` (`lemburID`, `nama`, `jabatan`, `golongan`, `jml_jam`, `gaji_perjam`, `total`) VALUES
(5, 'Muhammad Ali', 'Kepala HRD', 'I', 6, 20000, 120000),
(6, 'Nita', 'Sekertaris', 'I', 3, 15000, 45000);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `noID` int(3) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`noID`, `username`, `password`) VALUES
(2, 'admin', 'admin');

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
  MODIFY `karyawanID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `lembur`
--
ALTER TABLE `lembur`
  MODIFY `lemburID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `penggajian`
--
ALTER TABLE `penggajian`
  MODIFY `gajiID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `noID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
