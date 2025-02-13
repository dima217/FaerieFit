import { StatusBar, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import DateBlock from '@/components/DateBlock'
import globalStyles from '../../constants/style';
import MainTemplate from '@/components/mainApp/MainTemplate';

const Main = () => {
  return (
    <View style={{backgroundColor:'#474747', flex:1}}>
      <DateBlock/>
      <Text>asdfdd</Text>
    </View>
  )
}

export default Main

const styles = StyleSheet.create({})