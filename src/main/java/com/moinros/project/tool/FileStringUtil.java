package com.moinros.project.tool;

import java.util.UUID;

/**
 * 注释: 操作字符串的工具类
 * 
 * @Author [ moinros ]
 * @Website [ https://www.moinros.com ]
 * @Title StringUtil
 * @Version [ V - 1.0.0 β ]
 * @Data [ 2019年6月18日 上午11:40:31 ]
 */
public class FileStringUtil {

	/**
	 * 注释: 截取文件后缀名
	 *
	 * @param fileName 文件名
	 * @return String 文件后缀名
	 */
	public static String getFilePostfix(String fileName) {
		char[] arr = fileName.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = arr.length - 1;
		for (; i >= 0; i--) {
			if (arr[i] == '.') {
				break;
			}
		}
		i++;
		for (; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	/**
	 * 注释: 为文件重命名
	 *
	 * @param fileName 
	 * @return String
	 */
	public static String fileRename(String fileName) {
		String postfix = getFilePostfix(fileName);
		StringBuilder sb = new StringBuilder();
		sb.append(System.currentTimeMillis());
		sb.append('-');
		sb.append(UUID.randomUUID());
		sb.append('.');
		sb.append(postfix);
		return sb.toString();
	}

	/**
	 * 注释: 获取当前路径的上一级路径
	 *
	 * @param path 文件路径
	 * @return String
	 */
	public static String getFileUpPath(String path) {
		path = sortPath(path);
		if (path.length() > 2) {
			char[] arr = path.toCharArray();
			int i = arr.length - 2;
			StringBuilder sb = new StringBuilder();
			for (; i >= 0; i--) {
				if (arr[i] == '/') {
					break;
				}
			}
			for (int j = 0; j < i; j++) {
				sb.append(arr[j]);
			}
			return sb.toString();
		} else {
			return path;
		}

	}

	/**
	 * 注释: 整理磁盘路径;将 '\'替换为'/'
	 */
	public static String sortPath(String path) {
		StringBuilder sb = new StringBuilder();
		char[] arr = path.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '\\') {
				arr[i] = '/';

			}
			if (i > 1 && arr[i] == '/') {
				if (arr[i - 1] == '/') {
					continue;
				}
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}

}
