import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import DateBlock from '@/components/DateBlock'

const Main = () => {
  return (
    <SafeAreaView>
      <DateBlock/>
    </SafeAreaView>
  )
}

export default Main

const styles = StyleSheet.create({})